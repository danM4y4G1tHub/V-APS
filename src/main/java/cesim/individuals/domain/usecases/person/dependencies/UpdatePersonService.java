package cesim.individuals.domain.usecases.person.dependencies;

import cesim.individuals.domain.entities.Person;

public interface UpdatePersonService {
    Person update(String id, Person person);
}