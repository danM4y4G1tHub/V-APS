package cesim.individuals.domain.entities;

import java.util.List;

public record PractitionerRole(
    String resourceType,
    List<Identifier> identifier,
    boolean active,
    Period period,
    Reference practitioner,
    Reference organization,
    List<CodeableConcept> code,
    List<CodeableConcept> specialty,
    List<Reference> location,
    List<Reference> healthcareService,
    List<ExtendedContactDetail> contact,
    List<CodeableConcept> characteristic,
    List<CodeableConcept> communication,
    List<Availability> availability,
    List<Reference> endpoint
) {}
