package cesim.individuals.domain.entities.report.outputDTO.Test;

import java.util.List;

public record PatientDTO(
        String fullName,
        List<HumanNameDTO> name
) {
}
