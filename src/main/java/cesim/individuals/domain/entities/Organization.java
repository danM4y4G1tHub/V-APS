
package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
