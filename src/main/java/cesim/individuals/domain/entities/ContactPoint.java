package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public record ContactPoint(
        ContactPoint.System system,
        String value,
        ContactPoint.Use use,
        Integer rank,
        Period period) {
  public enum System {
    PHONE("phone"),
    FAX("fax"),
    EMAIL("email"),
    PAGER("pager"),
    URL("url"),
    SMS("sms"),
    OTHER("other");

    private final String value;

    System(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public enum Use {
    MOBILE("mobile"),
    HOME("home"),
    WORK("work"),
    TEMP("temp"),
    OLD("old"),
    BILLING("billing");

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
