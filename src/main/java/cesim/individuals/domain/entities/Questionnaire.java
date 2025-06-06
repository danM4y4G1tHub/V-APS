package cesim.individuals.domain.entities;

import java.util.List;

public record Questionnaire(
        String resourceType,
        List<Identifier> identifier,
        String title,
        List<Item> item
) {
  public enum Status {
    DRAFT("draft"),
    ACTIVE("active"),
    RETIRED("retired"),
    UNKNOWN("unknown");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public record Item(
          String linkId,
          String definition,
          List<Coding> code,
          String prefix,
          String text,
          Item.Type type,
          String enableBehavior,
          String disabledDisplay,
          Boolean required,
          List<Item> item
  ) {
    public enum Type {
      GROUP("group"),
      DISPLAY("display"),
      BOOLEAN("boolean"),
      DECIMAL("decimal"),
      INTEGER("integer"),
      DATE("date"),
      DATETIME("dateTime"),
      TIME("time");

      private final String value;

      Type(String value) {
        this.value = value;
      }

      public String getValue() {
        return value;
      }
    }
  }
}

