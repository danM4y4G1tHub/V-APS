package cesim.individuals.domain.usecases.relatedPerson.dependencies;

import cesim.individuals.domain.entities.RelatedPerson;

public interface CreateRelatedPersonService {
    RelatedPerson create(RelatedPerson relatedPerson);
}
