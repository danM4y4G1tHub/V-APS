package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Specimen(
        String resourceType,
        String id,
        List<Identifier> identifier,
        Identifier accessionIdentifier,
        Specimen.Status status,
        CodeableConcept type,
        Reference subject,
        LocalDateTime receivedTime,
        List<Reference> parent,
        List<Reference> request,
        Specimen.Combined combined,
        List<CodeableConcept> role,
        List<Feature> feature,
        Collection collection,
        List<Processing> processing,
        List<Container> container,
        List<CodeableConcept> condition,
        List<Annotation> note
) {
  public enum Status {
    AVAILABLE("available"),
    UNAVAILABLE("unavailable"),
    UNSATISFACTORY("unsatisfactory"),
    ENTERED_IN_ERROR("entered-in-error");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum Combined {
    GROUPED("grouped"),
    POOLED("pooled");

    private final String value;

    Combined(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public record Feature(
          CodeableConcept type,
          String description
  ) {
  }

  public record Collection(
          Reference collector,
          LocalDateTime collectedDateTime,
          Period collectedPeriod,
          Duration duration,
          Quantity quantity,
          CodeableConcept method,
          Reference device,
          Reference procedure,
          Reference bodySite,
          CodeableConcept fastingStatusCodeableConcept,
          Duration fastingStatusDuration
  ) {
  }

  public record Processing(
          String description,
          CodeableConcept method,
          List<Reference> additive,
          LocalDateTime timeDateTime,
          Period timePeriod
  ) {
  }

  public record Container(
          Reference device,
          Reference location,
          Quantity specimenQuantity
  ) {
  }
}
