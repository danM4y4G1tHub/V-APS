package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.report.outputDTO.CDRReportDTO;
import cesim.individuals.domain.entities.report.outputDTO.CommunityReportDTO;
import cesim.individuals.domain.usecases.report.dependencies.CommunityReportService;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.LocationRepository;
import cesim.individuals.infrastructure.repository.ObservationRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.ConditionModel;
import cesim.individuals.infrastructure.repository.models.LocationModel;
import cesim.individuals.infrastructure.repository.models.ObservationModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresCommunityReportService implements CommunityReportService {
  private final PatientRepository patientRepository;
  private final ConditionRepository conditionRepository;
  private final LocationRepository locationRepository;
  private final ObservationRepository observationRepository;

  @Override
  public CommunityReportDTO generateCommunityReport(String communityId) {
    LocationModel locationModel = locationRepository.findById(communityId)
            .orElseThrow(() -> new IllegalArgumentException("Community not found"));

    List<PatientModel> patients = patientRepository.findByLocation(communityId);

    return new CommunityReportDTO(
            locationModel.getResource().name(),
            patients.size(),
            calculateSickCount(patients),
            calculateCleanlinessScore(communityId),
            calculateDideaseIncidence(patients),
            calculateDemographicData(patients)
    );
  }

  @Override
  public List<CDRReportDTO> generateCDRReports(String communityId) {
    List<LocationModel> cdrs = locationRepository.findCDRByCommunity(communityId);

    return cdrs.stream().map(cdr -> {
      List<PatientModel> cdrPatiens = patientRepository.findByLocation(cdr.getId());

      return new CDRReportDTO(
              cdr.getResource().identifier().get(0).value(),
              cdrPatiens.size(),
              calculateSickCount(cdrPatiens),
              calculateCleanlinessScore(cdr.getId()),
              calculateDideaseIncidence(cdrPatiens),
              determineMainHealthConcern(cdrPatiens)
      );
    }).collect(Collectors.toList());
  }

  private int calculateSickCount(List<PatientModel> patients){
    List<String> patientIds = patients.stream()
            .map(PatientModel::getId)
            .collect(Collectors.toList());

    return conditionRepository.countActiveConditionsByPatients(patientIds);
  }

  private int calculateCleanlinessScore(String locationId){
    String codeJson = "[{\"code\":\"cleanliness-score\"}]";

    List<ObservationModel> observations = observationRepository.findByLocationAndCode(
            locationId, codeJson);

    return (int) observations.stream().
            mapToInt(obs -> obs.getResource().valueQuantity().value().intValue())
            .average()
            .orElse(5);
  }

  private Map<String, Integer> calculateDideaseIncidence(List<PatientModel> patients){
    List<String> patientsIds = patients.stream()
            .map(PatientModel::getId)
            .collect(Collectors.toList());

    List<ConditionModel> conditions = conditionRepository.findByPatientIds(patientsIds);

    return conditions.stream()
            .collect(Collectors.groupingBy(
                    cond -> cond.getResource().code().coding().get(0).display(),
                    Collectors.summingInt(c -> 1)
            ));
  }

  private CommunityReportDTO.DemographicData calculateDemographicData(List<PatientModel> patients){
    int children = 0, adults = 0, elderly = 0;
    int male = 0, female = 0;

    for (PatientModel patient: patients){
      Patient p = patient.getResource();
      LocalDate birthDate = p.birthDate();

      if(birthDate != null){
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        if (age < 18) children++;
        else if (age < 65) adults++;
        else elderly++;
      }

      if ("male".equalsIgnoreCase(p.gender().name())) male++;
      else if("female".equalsIgnoreCase(p.gender().name())) female++;
    }

    return new CommunityReportDTO.DemographicData(children, adults, elderly,male, female);
  }

  private String determineMainHealthConcern(List<PatientModel> patients){
    Map<String, Integer> incidence = calculateDideaseIncidence(patients);

    return incidence.entrySet().stream()
            .max(Map.Entry.comparingByKey())
            .map(Map.Entry::getKey)
            .orElse("No data");
  }
}
