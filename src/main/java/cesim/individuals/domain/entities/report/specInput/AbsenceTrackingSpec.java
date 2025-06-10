package cesim.individuals.domain.entities.report.specInput;

import java.time.LocalDate;

public record AbsenceTrackingSpec(
        LocalDate startDate, LocalDate endDate
) {
}
