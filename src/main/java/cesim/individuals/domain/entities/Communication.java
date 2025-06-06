package cesim.individuals.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Communication(
        List<Identifier> identifier,
        List<String> instantiatesCanonical,
        List<String> instantiatesUri,
        List<Reference> basedOn,
        List<Reference> partOf,
        List<Reference> inResponseTo,
        Communication.Status status,
        CodeableConcept statusReason,
        List<CodeableConcept> category,
        Communication.Priority priority,
        List<CodeableConcept> medium,
        Reference subject,
        CodeableConcept topic,
        List<Reference> about,
        Reference encounter,
        LocalDateTime sent,
        LocalDateTime received,
        List<Reference> recipient,
        List<Reference> sender,
        List<CodeableConcept> reason,
        List<Communication.Payload> payload,
        List<Annotation> note
) {

  public enum Status {
    PREPARATION("preparation"),
    IN_PROGRESS("in-progress"),
    NOT_DONE("not-done"),
    ON_HOLD("on-hold"),
    STOPPED("stopped"),
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

  // Nested enum for Communication Priority
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

  public record Payload(
          Attachment contentAttachment,
          Reference contentReference,
          CodeableConcept contentCodeableConcept
  ) {
  }
}