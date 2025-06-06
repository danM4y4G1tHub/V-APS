package cesim.individuals.domain.entities;

import java.util.List;

public record Concept(
        String code,
        String display,
        String definition,
        List<Designation> designation
) {
}
