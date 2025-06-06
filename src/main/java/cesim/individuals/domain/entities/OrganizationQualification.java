package cesim.individuals.domain.entities;

import java.util.List;

public record OrganizationQualification(
        List<Identifier> identifier,
        CodeableConcept code,
        Period period,
        Reference issuer) {

}
