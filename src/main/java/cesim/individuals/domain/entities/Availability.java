package cesim.individuals.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Availability(
        List<AvailableTime> availableTime,
        List<NotAvailableTime> notAvailable) {

  public record AvailableTime(
          List<AvailableTime.DaysOfWeek> daysOfWeek,
          String allDay,
          LocalDateTime availableStartTime,
          LocalDateTime availableEndTime) {
    public enum DaysOfWeek {
      MONDAY("mon"),
      TUESDAY("tue"),
      WEDNESDAY("wed"),
      THURSDAY("thu"),
      FRIDAY("fri"),
      SATURDAY("sat"),
      SUNDAY("sun");

      private final String value;

      DaysOfWeek(String value) {
        this.value = value;
      }

      public String getValue() {
        return value;
      }
    }
  }

  public record NotAvailableTime(
          String description,
          Period during) {
  }
}