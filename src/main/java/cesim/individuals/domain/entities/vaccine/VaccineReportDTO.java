package cesim.individuals.domain.entities.vaccine;

import java.time.LocalDate;
import java.util.List;

public record VaccineReportDTO(
        List<PatientVaccineStatus> patientStatuses,
        List<UpcomingDoseAlert> upcomingDoses
) {

  public record PatientVaccineStatus(
          String patientId,
          String patientName,
          String vaccineName,
          int appliedDoses,
          int totalDoses,
          LocalDate nextDoseDate
  ) {
  }

  public record UpcomingDoseAlert(
          String patientId,
          String patientName,
          String vaccineName,
          int nextDoseNumber,
          LocalDate dueDate
  ) {
  }
}
