package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AllergyIntolerance(
        String resourceType,
        String id,
        List<Identifier> identifier,
        CodeableConcept clinicalStatus,
        CodeableConcept verificationStatus,
        CodeableConcept type,
        List<String> category,
        String criticality,
        CodeableConcept code,
        Reference patient,
        Encounter encounter,
        LocalDateTime onsetDateTime,
        Age onsetAge,
        Period onsetPeriod,
        Range onsetRange,
        String onsetString,
        LocalDateTime recordedDate,
        List<Participant> participant,
        LocalDateTime lastOccurrence,
        List<Annotation> note,
        List<Reaction> reaction
) {
  public record Participant(
          CodeableConcept function,
          Reference actor // Practitioner
  ) {
  }

  public record Reaction(
          CodeableConcept substance,
          List<Observation> manifestation, // Placeholder for List<CodeableReference<Observation>>
          String description,
          LocalDateTime onset,
          String severity,
          CodeableConcept exposureRoute,
          List<Annotation> note
  ) {
  }
}
