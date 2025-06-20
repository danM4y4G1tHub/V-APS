package cesim.individuals.domain.entities.report.specInput;

import cesim.individuals.domain.entities.report.WhenPresent;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ClinicalReportFilterSpec(
                        @NotBlank(message = "Pathology code can't be empty",
                                groups = WhenPresent.class)
                        String pathologyCode,
                        @NotBlank(message = "Patient´s identifier(CI) can't be empty",
                                groups = WhenPresent.class)
                        @Size(min = 11, max = 11, message = "Patient´s identifier(CI) must have 11 characters",
                                groups = WhenPresent.class)
                        @Pattern(regexp = "\\d+", message = "Patient´s identifier(CI) must contain numeric digits",
                                groups = WhenPresent.class)
                        String patientIdentifier,
                        @NotBlank(message = "Patient's name can't be empty",
                                groups = WhenPresent.class)
                        String patientName,
                        @Pattern(
                                regexp = "^(male|female|other|unknown)?$",
                                message = "Inválid gender. Allowed values: male, female, other, unknown"
                        )
                        String patientGender,
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
