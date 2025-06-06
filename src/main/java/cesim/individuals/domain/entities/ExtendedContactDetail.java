package cesim.individuals.domain.entities;

import java.util.List;

public record ExtendedContactDetail(
    CodeableConcept purpose,
    List<ContactPoint> telecom,
    List<HumanName> name,
    Address address,
    Reference organization,
    Period period
) {}
