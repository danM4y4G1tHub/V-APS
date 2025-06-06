package cesim.individuals.domain.usecases.relatedPerson.dependencies;

import cesim.individuals.domain.entities.RelatedPerson;

public interface UpdateRelatedPersonService {
    RelatedPerson update(String id, RelatedPerson relatedPerson);
}
