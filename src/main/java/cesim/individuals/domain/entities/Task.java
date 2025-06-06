package cesim.individuals.domain.entities;

import java.util.List;

public record Task(
        String resourceType,
        String id,
        List<Identifier> identifier,
        Task.Status status,
        Reference statusReason,
        CodeableConcept businessStatus,
        Task.Intent intent,
        Task.Priority priority,
        Boolean doNotPerform,
        CodeableConcept code,
        String description
) {
  public enum Status {
    DRAFT("draft"),
    REQUESTED("requested"),
    RECEIVED("received"),
    ACCEPTED("accepted"); // + is ignored in enum

    private final String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum Intent {
    UNKNOWN("unknown"),
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
}
