package cesim.individuals.domain.entities;

import java.time.Instant;
import java.util.List;

public record Meta(
        String id,
        String versionId,
        Instant lastUpdated,
        String source,
        List<String> profile,      // Perfiles que este recurso reclama cumplir
        List<Coding> security,     // Etiquetas de seguridad
        List<Coding> tag           // Etiquetas para clasificación/organización
) {}
