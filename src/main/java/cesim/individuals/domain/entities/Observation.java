package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonValue;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record Observation(
        String resourceType,
        String id,
        List<Identifier> identifier,
        String instantiatesCanonical,
        Reference instantiatesReference,
        List<Reference> basedOn,
        List<TriggeredBy> triggeredBy,
        List<Reference> partOf,
        Observation.Status status,
        List<CodeableConcept> category,
        CodeableConcept code,
        Reference subject,
        List<Reference> focus,
        Reference encounter,
        LocalDateTime effectiveDateTime,
        Period effectivePeriod,
        Timing effectiveTiming,
        Instant effectiveInstant,
        Instant issued,
        List<Reference> performer,
        Quantity valueQuantity,
        CodeableConcept valueCodeableConcept,
        String valueString,
        Boolean valueBoolean,
        Integer valueInteger,
        Range valueRange,
        Ratio valueRatio,
        SampledData valueSampledData,
        LocalTime valueTime,
        LocalDateTime valueDateTime,
        Period valuePeriod,
        Attachment valueAttachment,
        Reference valueReference,
        CodeableConcept dataAbsentReason,
        List<CodeableConcept> interpretation,
        List<Annotation> note,
        CodeableConcept bodySite,
        Reference bodyStructure,
        CodeableConcept method,
        Specimen specimen,
        Reference device,
        List<ReferenceRange> referenceRange,
        List<Reference> hasMember,
        List<Reference> derivedFrom,
        List<Component> component
) {
  public enum Status {
    REGISTERED("registered"),
    PRELIMINARY("preliminary"),
    FINAL("final"),
    AMENDED("amended");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public record TriggeredBy(
          Reference observation,
          TriggeredBy.Type type,
          String reason
  ) {
    public enum Type {
      REFLEX("reflex"),
      REPEAT("repeat"),
      RE_RUN("re-run");

      private final String value;

      Type(String value) {
        this.value = value;
      }

      @JsonValue
      public String getValue() {
        return value;
      }
    }
  }

  public record ReferenceRange(
          Quantity low,
          Quantity high,
          CodeableConcept normalValue,
          CodeableConcept type,
          List<CodeableConcept> appliesTo,
          Range age,
          String text
  ) {
  }

  public record Component(
          CodeableConcept code,
          Quantity valueQuantity,
          CodeableConcept valueCodeableConcept,
          String valueString,
          Boolean valueBoolean,
          Integer valueInteger,
          Range valueRange,
          Ratio valueRatio,
          SampledData valueSampledData,
          LocalTime valueTime,
          LocalDateTime valueDateTime,
          Period valuePeriod,
          Attachment valueAttachment,
          Reference valueReference,
          CodeableConcept dataAbsentReason,
          List<CodeableConcept> interpretation,
          List<ReferenceRange> referenceRange
  ) {
  }
}
