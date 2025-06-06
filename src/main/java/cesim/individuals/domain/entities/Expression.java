package cesim.individuals.domain.entities;

public record Expression(
        String description,
        String name,
        String language,
        String expression,
        String reference
) {}
