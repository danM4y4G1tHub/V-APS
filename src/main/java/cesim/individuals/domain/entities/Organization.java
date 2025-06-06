
package cesim.individuals.domain.entities;

import java.util.List;

public record Organization(
        List<Identifier> identifier,
        Boolean active,
        String name,
        List<CodeableConcept> type,
        List<String> alias,
        String description,
        List<ExtendedContactDetail> contact,
        Reference partOf,
        Reference endpoint,
        OrganizationQualification qualification
) {
    
}
