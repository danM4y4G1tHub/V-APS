package cesim.individuals.domain.entities;


public record Reference(
        String reference,
        String type,
        Identifier identifier,
        String display) {
}
