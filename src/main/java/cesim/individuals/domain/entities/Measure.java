package cesim.individuals.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record Measure(
        String resourceType,
        String id,
        List<Identifier> identifier,
        String url,
        String version,
        String versionAlgorithmString,
        Coding versionAlgorithmCoding,
        String name,
        String title,
        String subtitle,
        Measure.Status status,
        Boolean experimental,
        CodeableConcept subjectCodeableConcept,
        Reference subjectReference,
        String basis,
        LocalDateTime date,
        String publisher,
        List<ContactDetail> contact,
        String description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        String purpose,
        String usage,
        String copyright,
        String copyrightLabel,
        LocalDate approvalDate,
        LocalDate lastReviewDate,
        Period effectivePeriod,
        List<CodeableConcept> topic,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<RelatedArtifact> relatedArtifact,
        List<String> library,
        String disclaimer,
        CodeableConcept scoring,
        CodeableConcept scoringUnit,
        CodeableConcept compositeScoring,
        List<CodeableConcept> type,
        String riskAdjustment,
        String rateAggregation,
        String rationale,
        String clinicalRecommendationStatement,
        CodeableConcept improvementNotation,
        List<Measure.Term> term,
        String guidance,
        List<Measure.Group> group,
        List<Measure.SupplementalData> supplementalData
) {

  public enum Status {
    DRAFT("draft"),
    ACTIVE("active"),
    RETIRED("retired"),
    UNKNOWN("unknown");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public record Term(
          CodeableConcept code,
          String definition
  ) {
  }

  public record Group(
          String linkId,
          CodeableConcept code,
          String description,
          List<CodeableConcept> type,
          CodeableConcept subjectCodeableConcept,
          Reference subjectReference,
          String basis,
          CodeableConcept scoring,
          CodeableConcept scoringUnit,
          String rateAggregation,
          CodeableConcept improvementNotation,
          List<String> library,
          List<Measure.Group.Population> population,
          List<Measure.Group.Stratifier> stratifier
  ) {
    public record Population(
            String linkId,
            CodeableConcept code,
            String description,
            Expression criteria,
            Reference groupDefinition,
            String inputPopulationId,
            CodeableConcept aggregateMethod
    ) {
    }

    public record Stratifier(
            String linkId,
            CodeableConcept code,
            String description,
            Expression criteria,
            Reference groupDefinition,
            List<Measure.Group.Stratifier.Component> component
    ) {
      public record Component(
              String linkId,
              CodeableConcept code,
              String description,
              Expression criteria,
              Reference groupDefinition
      ) {
      }
    }
  }

  public record SupplementalData(
          String linkId,
          CodeableConcept code,
          List<CodeableConcept> usage,
          String description,
          Expression criteria
  ) {
  }
}
