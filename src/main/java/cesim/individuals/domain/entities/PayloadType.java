package cesim.individuals.domain.entities;

import java.util.List;

public record PayloadType(
        List<CodeableConcept> type,
        List<String> mimeType) {
}
