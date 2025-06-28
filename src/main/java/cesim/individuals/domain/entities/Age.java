package cesim.individuals.domain.entities;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Objects;

public record Age(
        BigDecimal value,
        Comparator comparator,
        String unit,
        URI system,
        String code
) {

  public static Age of(BigDecimal value, String unit) {
    return new Age(value, null, unit, null, null);
  }

  public String toFhirString() {
    StringBuilder sb = new StringBuilder();

    if (comparator != null) {
      sb.append(comparator.toFhirCode());
    }

    sb.append(value.stripTrailingZeros().toPlainString());

    if (code != null) {
      sb.append(" ").append(code);
    } else if (unit != null) {
      sb.append(" ").append(unit);
    }

    return sb.toString();
  }

  public enum Comparator {
    LESS_THAN("<"),
    LESS_OR_EQUAL("<="),
    GREATER_OR_EQUAL(">="),
    GREATER_THAN(">");

    private final String fhirCode;

    Comparator(String fhirCode) {
      this.fhirCode = fhirCode;
    }

    public static Comparator fromFhirCode(String code) {
      return switch (code) {
        case "<" -> LESS_THAN;
        case "<=" -> LESS_OR_EQUAL;
        case ">=" -> GREATER_OR_EQUAL;
        case ">" -> GREATER_THAN;
        default -> throw new IllegalArgumentException("Código FHIR inválido: " + code);
      };
    }

    public String toFhirCode() {
      return fhirCode;
    }
  }
}
