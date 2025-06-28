package cesim.individuals.domain.entities.report.outputDTO.Test;

import java.util.List;

public record HumanNameDTO(
        List<String> family,
        List<String> given
) {
}
