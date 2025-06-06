package cesim.individuals.domain.entities.report.specInput;

import java.time.LocalDate;

public record RecentEncounterSpec(
        String practitionerId,
        LocalDate startDate,
        LocalDate endDate
) {
}
