package cesim.individuals.domain.entities;

import java.util.List;

public record Resourse(
        String id,
        Meta meta,
        Narrative text,
        List<Extension> extension,
        List<Reference> contained) {
}
