package cesim.individuals.domain.entities;

import java.math.BigDecimal;

public record Duration(
        BigDecimal value,
        String unit,
        String system,
        String code,
        Comparator comparator
) {
  public enum Comparator {
    LESS_THAN("<"),
    LESS_OR_EQUAL("<="),
    GREATER_OR_EQUAL(">="),
    GREATER_THAN(">");

    private final String fhirCode;

    Comparator(String fhirCode) {
      this.fhirCode = fhirCode;
    }

    public String getFhirCode() {
      return fhirCode;
    }
  }
}
