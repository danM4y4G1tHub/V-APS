package cesim.individuals.domain.entities;

public record Narrative(
        String status,
        String div
) {
  public enum NarrativeStatus {
    GENERATED,
    EXTENSIONS,
    ADDITIONAL,
    EMPTY
  }
}
