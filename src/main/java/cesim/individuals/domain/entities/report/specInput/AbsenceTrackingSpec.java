package cesim.individuals.domain.entities.report.specInput;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.groups.Default;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record   AbsenceTrackingSpec(
        @NotNull(message = "Start date obligatory!")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @PastOrPresent(message = "'from' date, must be past or present",
                groups = Default.class)
        LocalDate startDate,
        @NotNull(message = "End date obligatory!")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @PastOrPresent(message = "'from' date, must be past or present",
                groups = Default.class)
        LocalDate endDate
) {
}
