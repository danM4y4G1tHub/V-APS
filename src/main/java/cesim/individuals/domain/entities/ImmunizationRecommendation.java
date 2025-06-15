package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ImmunizationRecommendation(
        String resourceType,
        String id,
        Reference patient,
        List<Recommendation> recommendation
) {

  public record Recommendation(
          CodeableConcept vaccineCode,
          CodeableConcept forecastStatus,
          List<DateCriterion> dateCriterion,
          Integer doseNumber
  ) {
    public record DateCriterion(
            CodeableConcept code,
            LocalDateTime value
    ) {}
  }
}
