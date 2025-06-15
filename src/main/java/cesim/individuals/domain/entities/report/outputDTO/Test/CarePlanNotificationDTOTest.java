package cesim.individuals.domain.entities.report.outputDTO.Test;

import java.time.LocalDate;
import java.util.List;

public record CarePlanNotificationDTOTest(
        PatientDTO patientDTO,
        PractitionerDTO practitionerDTO,
        String message,
        LocalDate timestamp
) {}
