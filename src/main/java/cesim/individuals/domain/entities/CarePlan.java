package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CarePlan(
        String resourceType,
        String id,
        List<Identifier> identifier,
        List<String> instantiatesCanonical,
        List<String> instantiatesUri,
        List<Reference> basedOn,
        List<Reference> replaces,
        List<Reference> partOf,
        CarePlan.Status status,
        CarePlan.Intent intent,
        List<CodeableConcept> category,
        String title,
        String description,
        Reference subject,
        Reference encounter,
        Period period,
        LocalDateTime created,
        Reference custodian,
        List<Reference> contributor,
        List<Reference> careTeam,
        List<Reference> addresses,
        List<Reference> supportingInfo,
        List<Reference> goal,
        List<CarePlan.Activity> activity,
        List<Annotation> note
) {
  // Nested enum for CarePlan Status
  public enum Status {
    DRAFT("draft"),
    ACTIVE("active"),
    ON_HOLD("on-hold"),
    REVOKED("revoked"),
    COMPLETED("completed"),
    ENTERED_IN_ERROR("entered-in-error"),
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

  public enum Intent {
    PROPOSAL("proposal"),
    PLAN("plan"),
    ORDER("order"),
    OPTION("option"),
    DIRECTIVE("directive");

    private final String value;

    Intent(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public record Activity(
          List<Reference> performedActivity,
          List<Annotation> progress,
          Reference plannedActivityReference
  ) {
  }
}
