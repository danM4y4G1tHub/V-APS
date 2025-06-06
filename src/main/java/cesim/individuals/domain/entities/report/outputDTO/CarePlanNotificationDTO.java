package cesim.individuals.domain.entities.report.outputDTO;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.Practitioner;

import java.util.Date;

public record CarePlanNotificationDTO(
        String carePlanId,
        Patient patient,
        Practitioner practitioner,
        Date endDate,
        String notificationMessage
) {
}
