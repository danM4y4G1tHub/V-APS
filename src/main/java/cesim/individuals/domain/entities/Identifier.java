package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public record Identifier(
        Identifier.Use use,
        CodeableConcept type,
        String system,
        String value,
        Period period,
        Reference assigner) {
  public enum Use {
    USUAL("usual"),
    OFFICIAL("official"),
    TEMP("temp"),
    SECONDARY("secondary");

    private final String value;

    Use(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }
}
