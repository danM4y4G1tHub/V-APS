package cesim.individuals.domain.entities;

import java.util.List;

public record Contact(
    List<CodeableConcept> relationship,
    HumanName name,
    List<ContactPoint> telecom,
    Address address,
    String gender,
    Reference organization,
    Period period
) {}
