package cesim.individuals.domain.entities.report.outputDTO;

import cesim.individuals.domain.entities.*;
import cesim.individuals.domain.utils.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ClinicalReportDTO(
        Page<PatientInfo> patients,
        Page<ConditionsInfo> conditions
) {
  public record PatientInfo(
          List<Identifier> identifier,
          List<HumanName> name,
          Patient.Gender gender,
          LocalDate birthDate,
          List<ContactPoint> telecom,
          List<Address> address,
          CodeableConcept maritalStatus
  ) {
  }

  public record ConditionsInfo(
          CodeableConcept clinicalStatus,
          CodeableConcept code,
          LocalDateTime recordedDate,
          LocalDateTime onsetDateTime,
          Reference subject
  ) {
  }
}
