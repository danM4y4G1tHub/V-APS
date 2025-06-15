package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ServiceRequest(
        String resourceType,
        String id,
        List<Identifier> identifier,
        List<String> instantiatesCanonical,
        List<String> instantiatesUri,
        List<Reference> basedOn,
        List<Reference> replaces,
        Identifier requisition,
        ServiceRequest.Status status,
        ServiceRequest.Intent intent,
        List<CodeableConcept> category,
        ServiceRequest.Priority priority,
        Boolean doNotPerform,
        CodeableConcept code,
        List<OrderDetail> orderDetail,
        Quantity quantityQuantity,
        Ratio quantityRatio,
        Range quantityRange,
        Reference subject,
        List<Reference> focus,
        Reference encounter,
        LocalDateTime occurrenceDateTime,
        Period occurrencePeriod,
        Timing occurrenceTiming,
        Boolean asNeededBoolean,
        CodeableConcept asNeededCodeableConcept,
        LocalDateTime authoredOn,
        Reference requester,
        CodeableConcept performerType,
        List<Reference> performer,
        List<Reference> location,
        List<CodeableConcept> reason,
        List<Reference> insurance,
        List<CodeableConcept> supportingInfo,
        List<Reference> specimen,
        List<CodeableConcept> bodySite,
        Reference bodyStructure,
        List<Annotation> note,
        List<PatientInstruction> patientInstruction,
        List<Reference> relevantHistory
) {
  public enum Status {
    DRAFT("draft"),
    ACTIVE("active"),
    ON_HOLD("on-hold"),
    REVOKED("revoked"),
    COMPLETED("completed"),
    ENTERED_IN_ERROR("entered-in-error"),
    UNKNOWN("unknown");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum Intent {
    PROPOSAL("proposal"),
    PLAN("plan"),
    DIRECTIVE("directive"),
    ORDER("order");

    private final String value;

    Intent(String value) {
      this.value = value;
    }

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

    public String getValue() {
      return value;
    }
  }

  public record OrderDetail(
          CodeableConcept parameterFocus,
          List<Parameter> parameter
  ) {
    public record Parameter(
            CodeableConcept code,
            Quantity valueQuantity,
            Ratio valueRatio,
            Range valueRange,
            Boolean valueBoolean,
            CodeableConcept valueCodeableConcept,
            String valueString,
            Period valuePeriod
    ) {
    }
  }

  public record PatientInstruction(
          String instructionMarkdown,
          Reference instructionReference
  ) {
  }
}
