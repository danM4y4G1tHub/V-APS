package cesim.individuals.domain.entities;

import java.util.List;

public record Flag(
        String resourceType,
        String id,
        List<Identifier> identifier,
        Flag.Status status,
        List<CodeableConcept> category,
        CodeableConcept code,
        Reference subject,
        Period period,
        Reference encounter,
        Reference author
) {

  public enum Status {
    ACTIVE("active"),
    INACTIVE("inactive"),
    ENTERED_IN_ERROR("entered-in-error");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }
}
