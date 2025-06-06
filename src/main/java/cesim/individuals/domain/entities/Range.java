package cesim.individuals.domain.entities;

public record Range(
        Quantity<Double> low,
        Quantity<Double> high) {
}
