package cesim.individuals.domain.entities;

import java.time.Instant;

public record Period(
        Instant start,
        Instant end) {
}
