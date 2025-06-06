package cesim.individuals.domain.entities;

import java.time.Instant;
import java.util.Objects;

public record Annotation(
        AllergyIntolerance.Participant author,
        Instant time,
        String text
) {
  public Annotation {
    Objects.requireNonNull(text, "El texto de la anotación es obligatorio");
    if (time != null && time.isAfter(Instant.now())) {
      throw new IllegalArgumentException("La fecha de la anotación no puede ser futura");
    }
  }
}
