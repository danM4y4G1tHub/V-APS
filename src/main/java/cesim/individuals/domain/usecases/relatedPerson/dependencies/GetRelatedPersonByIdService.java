package cesim.individuals.domain.usecases.relatedPerson.dependencies;

import cesim.individuals.domain.entities.RelatedPerson;

public interface GetRelatedPersonByIdService {
    RelatedPerson getById(String id);
}
