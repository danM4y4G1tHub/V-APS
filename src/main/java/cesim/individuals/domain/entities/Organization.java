
package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Organization(
        String resourceType,
        String id,
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
