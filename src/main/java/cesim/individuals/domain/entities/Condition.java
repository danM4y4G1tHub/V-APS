package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Condition(
        String resourceType,
        String id,
        List<Identifier> identifier,
        CodeableConcept clinicalStatus,
        CodeableConcept verificationStatus,
        List<CodeableConcept> category,
        CodeableConcept severity,
        CodeableConcept code,
        List<CodeableConcept> bodySite,
        Reference subject,
        Reference encounter,
        LocalDateTime onsetDateTime,
        Age onsetAge,
        Period onsetPeriod,
        Range onsetRange,
        String onsetString,
        LocalDateTime abatementDateTime,
        Age abatementAge,
        Period abatementPeriod,
        Range abatementRange,
        String abatementString,
        LocalDateTime recordedDate,
        List<Condition.Participant> participant,
        List<Condition.Stage> stage,
        List<Reference> evidence,
        List<Annotation> note
) {
  public Condition(
          String id,
          CodeableConcept clinicalStatus,
          CodeableConcept code,
          Reference subject,
          Reference encounter,
          LocalDateTime recordedDate,
          List<Condition.Participant> participant
          ){
    this(
            "Condition",
            id,
            null,
            clinicalStatus,
            null,
            null,
            null,
            code,
            null,
            subject,
            encounter,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            recordedDate,
            participant,
            null,
            null,
            null
            );
  }

  public record Participant(
          CodeableConcept function,
          Reference actor
  ) {
  }

  public record Stage(
          CodeableConcept summary,
          List<Reference> assessment,
          CodeableConcept type
  ) {
  }
}
