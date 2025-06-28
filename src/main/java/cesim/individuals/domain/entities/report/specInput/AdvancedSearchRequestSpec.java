package cesim.individuals.domain.entities.report.specInput;

import cesim.individuals.domain.entities.report.WhenPresent;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
public record AdvancedSearchRequestSpec(
        @NotBlank(message = "Patient's name can't be empty",
                groups = WhenPresent.class)
        String name,
        @NotBlank(message = "Patient´s identifier(CI) can't be empty",
                groups = WhenPresent.class)
        @Size(min = 11, max = 11, message = "Patient´s identifier(CI) must have 11 characters",
                groups = WhenPresent.class)
        @Pattern(regexp = "\\d+", message = "Patient´s identifier(CI) must contain numeric digits",
                groups = WhenPresent.class)
        String identification,
        @NotBlank(message = "Diagnosis code can't be empty",
                groups = WhenPresent.class)
        String diagnosis,
        @NotNull(message = "Start date obligatory!", groups = Default.class)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @PastOrPresent(message = "'from' date, must be past or present",
                groups = Default.class)
        LocalDate fromDate,
        @NotNull(message = "End date obligatory!", groups = Default.class)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @PastOrPresent(message = "'to' date, must be past or present",
                groups = Default.class)
        LocalDate toDate
) {
}
