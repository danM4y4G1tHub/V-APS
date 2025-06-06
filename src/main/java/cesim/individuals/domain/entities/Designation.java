package cesim.individuals.domain.entities;

import java.util.List;

public record Designation(
        String language,
        Coding use,
        List<Coding> additionalUse,
        String value) {
}
