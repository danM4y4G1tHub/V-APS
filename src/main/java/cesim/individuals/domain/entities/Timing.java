package cesim.individuals.domain.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record Timing(
        List<Instant> event,
        Timing.TimingRepeat repeat,
        CodeableConcept code
) {
  public record TimingRepeat(
          Range bounds,
          Integer count,
          Integer countMax,
          BigDecimal duration,
          BigDecimal durationMax,
          String durationUnit,
          Integer frequency,
          Integer frequencyMax,
          BigDecimal period,
          BigDecimal periodMax,
          String periodUnit,
          List<String> dayOfWeek,
          List<String> timeOfDay,
          List<String> when,
          Integer offset
  ) {
  }
}
