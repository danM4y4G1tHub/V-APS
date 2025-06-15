package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Encounter(
        String resourceType,
        String id,
        List<Identifier> identifier,
        Encounter.Status status,
        List<CodeableConcept> classfhir,
        CodeableConcept priority,
        List<CodeableConcept> type,
        List<Reference> serviceType,
        Reference subject,
        CodeableConcept subjectStatus,
        List<Reference> episodeOfCare,
        List<Reference> basedOn,
        List<Reference> careTeam,
        Reference partOf,
        Reference serviceProvider,
        List<Encounter.Participant> participant,
        List<Reference> appointment,
        List<VirtualServiceDetail> virtualService,
        Period actualPeriod,
        LocalDateTime plannedStartDate,
        LocalDateTime plannedEndDate,
        Duration length,
        List<Encounter.Reason> reason,
        List<Encounter.Diagnosis> diagnosis,
        List<Reference> account,
        List<CodeableConcept> dietPreference,
        List<CodeableConcept> specialArrangement,
        List<CodeableConcept> specialCourtesy,
        Encounter.Admission admission,
        List<Encounter.Location> location
) {

  public enum Status {
    PLANNED("planned"),
    IN_PROGRESS("in-progress"),
    ON_HOLD("on-hold"),
    DISCHARGED("discharged"),
    COMPLETED("completed"),
    CANCELLED("cancelled"),
    DISCONTINUED("discontinued"),
    ENTERED_IN_ERROR("entered-in-error"),
    FINISHED("finished"),
    UNKNOWN("unknown");

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
          Reference actor
  ) {
  }

  public record Reason(
          List<CodeableConcept> use,
          List<Reference> value
  ) {
  }

  public record Diagnosis(
          List<Reference> condition,
          List<CodeableConcept> use
  ) {
  }

  public record Admission(
          Identifier preAdmissionIdentifier,
          Reference origin, // Placeholder for Reference(Location|Organization)
          CodeableConcept admitSource,
          CodeableConcept reAdmission,
          Reference destination,
          CodeableConcept dischargeDisposition
  ) {
  }

  public record Location(
          Reference location,
          LocationStatus status,
          CodeableConcept form,
          Period period
  ) {

    public enum LocationStatus {
      PLANNED("planned"),
      ACTIVE("active"),
      RESERVED("reserved"),
      COMPLETED("completed");

      private final String value;

      LocationStatus(String value) {
        this.value = value;
      }

      @JsonValue
      public String getValue() {
        return value;
      }
    }
  }
}
