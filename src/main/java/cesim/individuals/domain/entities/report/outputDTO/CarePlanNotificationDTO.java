package cesim.individuals.domain.entities.report.outputDTO;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.Practitioner;

import java.time.Instant;
import java.util.Date;

public record CarePlanNotificationDTO(
        String carePlanId,
        Patient patient,
        Practitioner practitioner,
        Instant endDate,
        String notificationMessage
) {
}
