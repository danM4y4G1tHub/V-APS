package cesim.individuals.domain.usecases.person.dependencies;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public interface SearchPersonService {
    Page<Person> search(Pageable pageable, String query);
}
