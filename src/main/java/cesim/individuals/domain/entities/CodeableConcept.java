package cesim.individuals.domain.entities;

import java.util.List;

public record CodeableConcept(
        List<Coding> coding,
        String text
) {
}
