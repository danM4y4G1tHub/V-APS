package cesim.individuals.domain.usecases.practitioner.dependencies;

import cesim.individuals.domain.entities.Practitioner;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public interface SearchPractitionerService {
    Page<Practitioner> search(Pageable pageable, String query);
}
