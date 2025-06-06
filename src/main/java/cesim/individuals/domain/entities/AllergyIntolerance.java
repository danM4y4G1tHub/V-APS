package cesim.individuals.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

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
        Age onsetAge, // Placeholder for Age
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
