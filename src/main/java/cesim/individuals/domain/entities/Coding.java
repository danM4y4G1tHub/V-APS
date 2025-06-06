package cesim.individuals.domain.entities;

public record Coding(
        String system,
        String version,
        String code,
        String display,
        Boolean userSelected) {
}
