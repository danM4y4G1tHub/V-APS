package cesim.individuals.domain.entities.vaccine;

import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class OfficialVaccineCalendar {
  public List<VaccineScheduleDTO> getSchedules(){
    return Arrays.asList(
            new VaccineScheduleDTO(
                    "01",
                    "Hepatitis B",
                    List.of(
                            new VaccineScheduleDTO.DoseSchedule(
                                    1, Period.ZERO, Period.ofMonths(1), Period.ZERO),
                            new VaccineScheduleDTO.DoseSchedule(
                                    2, Period.ofMonths(1), Period.ofMonths(2), Period.ofMonths(1)
                            ),
                            new VaccineScheduleDTO.DoseSchedule(
                                    3, Period.ofMonths(6), Period.ofMonths(18), Period.ofMonths(6)
                            )
                    )
            ),
            new VaccineScheduleDTO(
                    "44",
                    "Influenza",
                    List.of(
                            new VaccineScheduleDTO.DoseSchedule(
                                    1,
                                    Period.ofMonths(6),
                                    null,
                                    Period.ZERO),
                            new VaccineScheduleDTO.DoseSchedule(
                                    2,
                                    Period.ofMonths(7),
                                    null,
                                    Period.ofYears(1))
                    )
            ),
            new VaccineScheduleDTO(
                    "111",
                    "COVID-19",
                    List.of(
                            new VaccineScheduleDTO.DoseSchedule(
                                    1, Period.ofMonths(12), null, Period.ZERO),
                            new VaccineScheduleDTO.DoseSchedule(
                                    2, Period.ofMonths(12).plusDays(21), null,
                                    Period.ofDays(21)),
                            new VaccineScheduleDTO.DoseSchedule(
                                    3, Period.ofMonths(6), null, Period.ofMonths(6)
                            )
                    )
            )
    );
  }
}
