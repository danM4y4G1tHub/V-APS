package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MedicationRequest(
        String resourceType,
        String id,
        List<Identifier> identifier,
        List<Reference> basedOn,
        Reference priorPrescription,
        Identifier groupIdentifier,
        MedicationRequest.Status status,
        List<CodeableConcept> reasonCode,
        LocalDateTime statusChanged,
        MedicationRequest.Intent intent,
        List<CodeableConcept> category,
        MedicationRequest.Priority priority,
        Boolean doNotPerform,
        Reference medication,
        Reference subject,
        List<Reference> informationSource,
        Reference encounter,
        List<Reference> supportingInformation,
        LocalDateTime authoredOn,
        Reference requester,
        Boolean reported,
        CodeableConcept performerType,
        List<Reference> performer,
        List<Reference> device,
        Reference recorder,
        List<Reference> reason,
        CodeableConcept courseOfTherapyType,
        List<Reference> insurance,
        List<Annotation> note,
        String renderedDosageInstruction,
        Period effectiveDosePeriod,
        List<Dosage> dosageInstruction,
        DispenseRequest dispenseRequest,
        Substitution substitution,
        List<Reference> eventHistory
) {
  public MedicationRequest(
          String id,
          MedicationRequest.Status status,
          MedicationRequest.Intent intent,
          Reference medication,
          Reference subject,
          Reference requester,
          List<Reference> reason,
          List<Dosage> dosageInstruction,
          String renderedDosageInstruction,
          LocalDateTime authoredOn
          ){
    this(
            "MedicationRequest",
            id,
            null,
            null,
            null,
            null,
            status,
            null,
            null,
            intent,
            null,
            null,
            null,
            medication,
            subject,
            null,
            null,
            null,
            authoredOn,
            requester,
            null,
            null,
            null,
            null,
            null,
            reason,
            null,
            null,
            null,
            renderedDosageInstruction,
            null,
            dosageInstruction,
            null,
            null,
            null
    );
  }

  public enum Status {
    ACTIVE("active"),
    ON_HOLD("on-hold"),
    ENDED("ended"),
    STOPPED("stopped"),
    COMPLETED("completed"),
    CANCELLED("cancelled"),
    ENTERED_IN_ERROR("entered-in-error"),
    DRAFT("draft"),
    UNKNOWN("unknown");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public enum Intent {
    PROPOSAL("proposal"),
    PLAN("plan"),
    ORDER("order"),
    ORIGINAL_ORDER("original-order"),
    REFLEX_ORDER("reflex-order"),
    FILLER_ORDER("filler-order"),
    INSTANCE_ORDER("instance-order"),
    OPTION("option");

    private final String value;

    Intent(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public enum Priority {
    ROUTINE("routine"),
    URGENT("urgent"),
    ASAP("asap"),
    STAT("stat");

    private final String value;

    Priority(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public record DispenseRequest(
          InitialFill initialFill,
          Duration dispenseInterval,
          Period validityPeriod,
          Integer numberOfRepeatsAllowed,
          Quantity quantity,
          Duration expectedSupplyDuration,
          Reference dispenser,
          List<Annotation> dispenserInstruction,
          CodeableConcept doseAdministrationAid
  ) {
    public record InitialFill(
            Quantity quantity,
            Duration duration
    ) {
    }
  }

  public record Substitution(
          Boolean allowedBoolean,
          CodeableConcept allowedCodeableConcept,
          CodeableConcept reason
  ) {
  }
}
