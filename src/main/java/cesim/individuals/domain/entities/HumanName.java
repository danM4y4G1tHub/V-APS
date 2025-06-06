package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public record HumanName(
        HumanName.Use use,
        String text,
        String family,
        List<String> given,
        List<String> prefix,
        List<String> suffix,
        Period period
) {

  public enum Use {
    USUAL("usual"),
    OFFICIAL("official"),
    TEMP("temp"),
    NICKNAME("nickname"),
    ANONYMOUS("anonymous"),
    OLD("old"),
    MAIDEN("maiden");

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
