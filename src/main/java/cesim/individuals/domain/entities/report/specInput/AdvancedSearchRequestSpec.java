package cesim.individuals.domain.entities.report.specInput;

import java.time.LocalDate;

public record AdvancedSearchRequestSpec(
        String name,
        String identification,
        String diagnosis,
        LocalDate fromDate,
        LocalDate toDate
) {
}
