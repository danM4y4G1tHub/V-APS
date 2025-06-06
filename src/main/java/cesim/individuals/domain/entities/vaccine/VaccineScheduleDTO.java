package cesim.individuals.domain.entities.vaccine;

import cesim.individuals.domain.entities.Period;

import java.util.List;

public record VaccineScheduleDTO(
        String vaccineId,
        String displayName,
        List<DoseSchedule> doseSchedules
) {
  public record DoseSchedule(
          int doseNumber,
          Period minAge,
          Period recommendedInterval
  ) {
  }
}
