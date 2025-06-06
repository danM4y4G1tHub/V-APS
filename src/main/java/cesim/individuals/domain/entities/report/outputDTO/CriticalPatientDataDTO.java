package cesim.individuals.domain.entities.report.outputDTO;

import cesim.individuals.domain.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CriticalPatientDataDTO(
        PatientInfo patient,
        List<AllergiesInfo> allergies,
        List<MedicationsInfo> medications,
        List<ConditionsInfo> conditions,
        List<EncounterInfo> encounterInfo,
        List<ObservationsInfo> observations,
        PractitionerInfo practitioner,
        List<RelatedPersonInfo> relatedPersons,
        List<CarePlanInfo> caresPlanInfo
) {

  public record PatientInfo(
          List<HumanName> name,
          Patient.Gender gender,
          LocalDate birthDate,
          List<ContactPoint> telecom,
          List<Address> address,
          CodeableConcept maritalStatus
  ) {
  }

  public record AllergiesInfo(
          CodeableConcept code,
          CodeableConcept clinicalStatus,
          List<AllergyIntolerance.Reaction> reaction
  ) {
  }

  public record MedicationsInfo(
          MedicationRequest.Status status,
          MedicationRequest.Intent intent,
          Reference medication,
          List<Dosage> dosageInstruction,
          List<CodeableConcept> reasonCode
  ) {
  }

  public record ConditionsInfo(
          CodeableConcept clinicalStatus,
          CodeableConcept code,
          LocalDateTime recordedDate
  ) {
  }

  public record EncounterInfo(
          Period actualPeriod,
          List<CodeableConcept> type,
          List<Encounter.Reason> reason
  ) {
  }

  public record ObservationsInfo(
          CodeableConcept code,
          Quantity valueQuantity,
          LocalDateTime effectiveDateTime
  ) {
  }

  public record PractitionerInfo(
          List<HumanName> name,
          List<Identifier> identifier,
          List<Practitioner.Qualification> qualification
  ) {
  }

  public record RelatedPersonInfo(
          List<HumanName> name,
          List<CodeableConcept> relationship,
          List<ContactPoint> telecom
  ) {
  }

  public record CarePlanInfo(
          CarePlan.Status status,
          CarePlan.Intent intent,
          List<CarePlan.Activity> activity
  ) {
  }
}
