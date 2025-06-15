package cesim.individuals.domain.entities.report.outputDTO.Test;

import java.util.List;

public record PractitionerDTO (
        String fullName,
        List<HumanNameDTO> name
){
}
