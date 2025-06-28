package cesim.individuals.domain.entities.vaccine;

import java.time.Period;
import java.util.List;

public record VaccineScheduleDTO(
        String vaccineId,
        String displayName,
        List<DoseSchedule> doseSchedules
) {
  public record DoseSchedule(
          int doseNumber,
          Period minAge,
          Period maxAge,
          Period recommendedInterval
  ) {
  }
}
