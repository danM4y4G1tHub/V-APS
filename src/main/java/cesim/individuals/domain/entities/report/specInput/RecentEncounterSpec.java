package cesim.individuals.domain.entities.report.specInput;

import cesim.individuals.domain.entities.report.WhenPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record RecentEncounterSpec(
        @NotBlank(message = "Practitioner´s id can't be empty and it's obligatory",
                groups = WhenPresent.class)
        @Pattern(
                regexp = "^[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$",
                message = "Invalid UUID",
                flags = Pattern.Flag.CASE_INSENSITIVE
        )
        String practitionerId,
        @NotNull(message = "Start date obligatory!")
        @PastOrPresent(message = "Start date must be past or present")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate startDate,
        @NotNull(message = "End date obligatory!")
        @PastOrPresent(message = "End date must be past or present")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate endDate
) {
}
