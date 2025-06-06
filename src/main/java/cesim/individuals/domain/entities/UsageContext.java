package cesim.individuals.domain.entities;

public record UsageContext(
        Coding code,
        CodeableConcept valueCodeableConcept,
        Quantity<Double> valueQuantity,
        Range valueRange,
        Reference valueReference) {
}
