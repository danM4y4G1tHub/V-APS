package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.report.outputDTO.RecentEncounterDTO;
import cesim.individuals.domain.entities.report.specInput.RecentEncounterSpec;
import cesim.individuals.domain.usecases.report.dependencies.GetRecentEncounterService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.EncounterRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.PractitionerRepository;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import cesim.individuals.infrastructure.repository.models.PractitionerModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresGetEncounterService implements GetRecentEncounterService {
  private final EncounterRepository encounterRepository;
  private final PatientRepository patientRepository;
  private final PractitionerRepository practitionerRepository;

  @Override
  public Page<RecentEncounterDTO> getRecentEncounters(Pageable pageable, RecentEncounterSpec encounterSpec) {
    if(encounterSpec.startDate() == null && encounterSpec.endDate() == null){
      throw new IllegalArgumentException("Start date and end date missing");
    }

    Date startDate = Date.from(
            encounterSpec
                    .startDate()
                    .atStartOfDay(ZoneId.systemDefault())
                    .toInstant());
    Date endDate = Date.from(
            encounterSpec
                    .endDate()
                    .plusDays(1)
                    .atStartOfDay(ZoneId.systemDefault())
                    .toInstant());

//    String startDate = encounterSpec.startDate().toString();
//    String endDate = encounterSpec.endDate().plusDays(1).toString();

    String practitionerRef = "Practitioner/" + encounterSpec.practitionerId();

    var sort = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var encounterResults = encounterRepository.findByPractitionerAndDateRange(
            practitionerRef,
            startDate,
            endDate,
            PageRequest.of(
                    pageable.page(),
                    pageable.size(),
                    sort
            ));

    List<String> patientIds = encounterResults.getContent().stream()
            .map(e ->
                    e.getResource().subject().reference().split("/")[1])
            .distinct().toList();

    List<String> practitionerIds = encounterResults.getContent().stream()
            .map(e ->
                    e.getResource().participant().get(0).individual().reference().split("/")[0])
            .distinct().toList();

    List<RecentEncounterDTO> encounterDTOS = encounterResults.getContent().stream()
            .map(encounter -> {
              Date dateObj = encounter.getResource().period().start();
              LocalDateTime date = dateObj.toInstant()
                      .atZone(ZoneId.systemDefault())
                      .toLocalDateTime();

              String type = encounter.getResource().type().get(0).coding().get(0).display();

              String patientId = encounter.getResource().subject().reference().split("/")[1];
              String practitionerIdRef = encounter.getResource()
                      .participant().get(0).individual().reference().split("/")[1];

              return new RecentEncounterDTO(
                      date,
                      type,
                      mapPractitioners(patientIds).get(patientId),
                      mapPatients(practitionerIds).get(practitionerIdRef)
              );
            }).toList();

    return new Page<>(
            encounterResults.getNumber(),
            encounterResults.getSize(),
            encounterResults.getTotalPages(),
            encounterDTOS
    );
  }

  private Map<String, String> mapPatients(List<String> patientIds) {
    if(patientIds == null || patientIds.isEmpty()) return null;

    return patientRepository.findAllById(patientIds).
            stream().collect(Collectors.toMap(
                    PatientModel::getId,
                    pm -> pm.getResource().name().get(0).family() + ", " +
                            pm.getResource().name().get(0).given().get(0)
            ));
  }

  private Map<String, String> mapPractitioners(List<String> practitionerIds) {
    if(practitionerIds.isEmpty()) return null;

    return practitionerRepository.findAllById(practitionerIds)
            .stream().collect(Collectors.toMap(
                    PractitionerModel::getId,
                    pm -> pm.getResource().name().get(0).family() + ", " +
                            pm.getResource().name().get(0).given().get(0)
            ));
  }
}
