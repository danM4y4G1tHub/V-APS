package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Appointment(
        String resourceType,
        String id,
        List<Identifier> identifier,
        Appointment.Status status,
        CodeableConcept cancellationReason,
        List<CodeableConcept> classs,
        List<CodeableConcept> serviceCategory,
        List<Reference> serviceType,
        List<CodeableConcept> specialty,
        CodeableConcept appointmentType,
        List<Reference> reason,
        CodeableConcept priority,
        String description,
        List<Reference> replaces,
        List<VirtualServiceDetail> virtualService,
        List<Reference> supportingInformation,
        Reference previousAppointment,
        Reference originatingAppointment,
        Instant start,
        Instant end,
        Integer minutesDuration,
        List<Period> requestedPeriod,
        List<Reference> slot,
        List<Reference> account,
        LocalDateTime created,
        LocalDateTime cancellationDate,
        List<Annotation> note,
        List<Reference> patientInstruction,
        List<Reference> basedOn,
        Patient subject,
        List<Appointment.Participant> participant,
        Integer recurrenceId,
        Boolean occurrenceChanged,
        List<Appointment.RecurrenceTemplate> recurrenceTemplate
) {

  public enum Status {
    PROPOSED("proposed"),
    PENDING("pending"),
    BOOKED("booked"),
    ARRIVED("arrived"),
    FULFILLED("fulfilled"),
    CANCELLED("cancelled"),
    NOSHOW("noshow"),
    ENTERED_IN_ERROR("entered-in-error"),
    CHECKED_IN("checked-in"),
    WAITLIST("waitlist"),
    FINISHED("finished");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public record Participant(
          List<CodeableConcept> type,
          Period period,
          Reference actor,
          Boolean required,
          Participant.Status status
  ) {

    public enum Status {
      ACCEPTED("accepted"),
      DECLINED("declined"),
      TENTATIVE("tentative"),
      NEEDS_ACTION("needs-action");

      private final String value;

      Status(String value) {
        this.value = value;
      }

      @JsonValue
      public String getValue() {
        return value;
      }
    }
  }

  public record RecurrenceTemplate(
          CodeableConcept timezone,
          RecurrenceTemplate.RecurrenceType recurrenceType,
          LocalDate lastOccurrenceDate,
          Integer occurrenceCount,
          List<LocalDate> occurrenceDate,
          WeeklyTemplate weeklyTemplate,
          MonthlyTemplate monthlyTemplate,
          YearlyTemplate yearlyTemplate,
          List<LocalDate> excludingDate,
          List<Integer> excludingRecurrenceId
  ) {

    public enum RecurrenceType {
      DAILY("daily"),
      WEEKLY("weekly"),
      MONTHLY("monthly"),
      YEARLY("yearly"),
      OTHER("other");


      private final String value;

      RecurrenceType(String value) {
        this.value = value;
      }

      @JsonValue
      public String getValue() {
        return value;
      }
    }

    public record WeeklyTemplate(
            Boolean monday,
            Boolean tuesday,
            Boolean wednesday,
            Boolean thursday,
            Boolean friday,
            Boolean saturday,
            Boolean sunday,
            Integer weekInterval
    ) {}

    public record MonthlyTemplate(
            Integer dayOfMonth,
            Coding nthWeekOfMonth,
            Coding dayOfWeek,
            Integer monthInterval
    ) {}

    public record YearlyTemplate(
            Integer yearInterval
    ) {}
  }
}
