package cesim.individuals.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

public record MeasureReport(
        String resourceType,
        String id,
        List<Identifier> identifier,
        MeasureReport.Status status,
        MeasureReport.Type type,
        MeasureReport.DataUpdateType dataUpdateType,
        String measure,
        Reference subject,
        LocalDateTime date,
        Reference reporter,
        Reference reportingVendor,
        Reference location,
        Period period,
        Reference inputParameters,
        CodeableConcept scoring,
        CodeableConcept improvementNotation,
        List<MeasureReport.Group> group,
        List<Reference> supplementalData,
        List<Reference> evaluatedResource
) {

  public enum Status {
    COMPLETE("complete"),
    PENDING("pending"),
    ERROR("error");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum Type {
    INDIVIDUAL("individual"),
    SUBJECT_LIST("subject-list"),
    SUMMARY("summary"),
    DATA_EXCHANGE("data-exchange");

    private final String value;

    Type(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum DataUpdateType {
    INCREMENTAL("incremental"),
    SNAPSHOT("snapshot");

    private final String value;

    DataUpdateType(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public record Group(
          String linkId,
          CodeableConcept code,
          Reference subject,
          List<MeasureReport.Group.Population> population,
          Quantity measureScoreQuantity,
          LocalDateTime measureScoreDateTime,
          CodeableConcept measureScoreCodeableConcept,
          Period measureScorePeriod,
          Range measureScoreRange,
          Duration measureScoreDuration,
          List<MeasureReport.Group.Stratifier> stratifier
  ) {
    public record Population(
            String linkId,
            CodeableConcept code,
            Integer count,
            Reference subjectResults,
            List<Reference> subjectReport,
            Reference subjects
    ) {
    }

    public record Stratifier(
            String linkId,
            CodeableConcept code,
            List<Group.Stratifier.Stratum> stratum
    ) {
      public record Stratum(
              CodeableConcept valueCodeableConcept,
              Boolean valueBoolean,
              Quantity valueQuantity,
              Range valueRange,
              Reference valueReference,
              List<Group.Stratifier.Stratum.Component> component,
              List<Group.Stratifier.Stratum.Population> population,
              Quantity measureScoreQuantity,
              LocalDateTime measureScoreDateTime,
              CodeableConcept measureScoreCodeableConcept,
              Period measureScorePeriod,
              Range measureScoreRange,
              Duration measureScoreDuration
      ) {
        public record Component(
                String linkId,
                CodeableConcept code,
                CodeableConcept valueCodeableConcept,
                Boolean valueBoolean,
                Quantity valueQuantity,
                Range valueRange,
                Reference valueReference
        ) {
        }

        public record Population(
                String linkId,
                CodeableConcept code,
                Integer count,
                Reference subjectResults,
                List<Reference> subjectReport,
                Reference subjects
        ) {
        }
      }
    }
  }
}
