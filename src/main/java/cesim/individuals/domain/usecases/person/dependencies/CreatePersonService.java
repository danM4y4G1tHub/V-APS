package cesim.individuals.domain.usecases.person.dependencies;

import cesim.individuals.domain.entities.Person;

public interface CreatePersonService {
  Person create(Person person);
}
