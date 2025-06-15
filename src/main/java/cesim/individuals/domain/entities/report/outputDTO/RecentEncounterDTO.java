package cesim.individuals.domain.entities.report.outputDTO;

import java.time.Instant;

public record RecentEncounterDTO(
        Instant date,
        String type,
        String practitionerName,
        String patientName
) {
}
