package cesim.individuals.domain.entities;

import java.time.Instant;
import java.util.List;

public record Signature(
        String id,
        List<Coding> type,
        Instant when,
        Reference who,
        Reference onBehalfOf,
        String targetFormat,
        String sigFormat,
        String data,
        List<Extension> extension
) {}
