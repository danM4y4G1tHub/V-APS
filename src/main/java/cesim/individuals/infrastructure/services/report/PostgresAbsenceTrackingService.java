package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.report.outputDTO.AbsenceReportDTO;
import cesim.individuals.domain.entities.report.specInput.AbsenceTrackingSpec;
import cesim.individuals.domain.usecases.report.dependencies.AbsenceTrackingService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.AppointmentRepository;
import cesim.individuals.infrastructure.repository.EncounterRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresAbsenceTrackingService implements AbsenceTrackingService {
  private final AppointmentRepository appointmentRepository;
  private final EncounterRepository encounterRepository;
  private final PatientRepository patientRepository;

  @Override
  public Page<AbsenceReportDTO> findAbsences(Pageable pageable, AbsenceTrackingSpec spec) {
    if(spec == null) throw new IllegalArgumentException("StartDate and EndDate missing");

    var appointmentSort = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var appointmentResults = appointmentRepository.findAbsencesByDateRange(
            PageRequest.of(pageable.page(), pageable.size(), appointmentSort),
            spec.startDate(), spec.endDate());

    List<AbsenceReportDTO> absences = appointmentResults.getContent().stream()
            .map(a -> {
              String patientId = (String) a[2];
              String familyName = (String) a[3];
              String givenName = (String) a[4];
              String fullName = (givenName != null ? givenName + " " : "") +
                      (familyName != null ? familyName : "");

              return new AbsenceReportDTO(
                      patientId,
                      fullName,
                      LocalDateTime.parse((String) a[1], DateTimeFormatter.ISO_DATE_TIME)
              );
            }).collect(Collectors.toList());

    return new Page<>(
            appointmentResults.getNumber(),
            appointmentResults.getSize(),
            appointmentResults.getTotalPages(),
            absences
    );
  }
}
