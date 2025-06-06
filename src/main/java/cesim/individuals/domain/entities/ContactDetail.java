package cesim.individuals.domain.entities;

import java.util.List;

public record ContactDetail(
        String name,
        List<ContactPoint> telecom) {
}
