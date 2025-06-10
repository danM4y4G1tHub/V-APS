package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImmunizationRecommendation(
        String id,
        Reference patient,
        List<Recommendation> recommendation
) {

  public record Recommendation(
          CodeableConcept vaccineCode,
          ForecastStatus forecastStatus,
          List<DateCriterion> dateCriterion,
          String doseNumber
  ) {
    public record ForecastStatus(
            List<Coding> coding
    ) {
      public record Coding(
              String code,
              String display
      ) {}
    }

    public record DateCriterion(
            Code code,
            LocalDateTime value
    ) {
      public record Code(String text) {}
    }
  }
}
