package cesim.individuals.domain.entities.report.outputDTO;

import java.time.LocalDateTime;

public record AbsenceReportDTO(
        String patientId,
        String patientName,
        LocalDateTime scheduledDate
) {
}
