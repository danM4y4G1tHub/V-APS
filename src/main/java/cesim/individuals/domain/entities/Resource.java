package cesim.individuals.domain.entities;

import java.util.List;

public record Resource(
        String id,
        Meta meta,
        Narrative text,
        List<Extension> extension,
        List<Reference> contained) {
}
