package cesim.individuals.domain.entities.report.outputDTO;

import java.time.LocalDateTime;

public record RecentEncounterDTO(
        LocalDateTime date,
        String type,
        String practitionerName,
        String patientName
) {
}
