package cesim.individuals.domain.usecases.relatedPerson.dependencies;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public interface SearchRelatedPersonService {
    Page<RelatedPerson> search(Pageable pageable, String query);
}
