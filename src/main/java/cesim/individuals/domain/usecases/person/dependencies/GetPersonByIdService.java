package cesim.individuals.domain.usecases.person.dependencies;

import cesim.individuals.domain.entities.Person;

public interface GetPersonByIdService {
    Person getById(String id);
}
