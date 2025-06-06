package cesim.individuals.domain.entities.report.outputDTO;

import cesim.individuals.domain.entities.CodeableConcept;
import cesim.individuals.domain.entities.Dosage;
import cesim.individuals.domain.entities.HumanName;

import java.util.List;

public record DerivationReportDTO(
        PatientInfo patient,
        List<ConditionInfo> diagnostic,
        List<MedicationInfo> medications,
        List<AllergyInfo> allergies
) {
  public record PatientInfo(List<HumanName> name) {
  }

  public record ConditionInfo(CodeableConcept code) {
  }

  public record MedicationInfo(List<Dosage> dosageInstruction) {
  }

  public record AllergyInfo(CodeableConcept code) {
  }
}
