package cesim.individuals.infrastructure.services.person;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.person.dependencies.UpdatePersonService;
import cesim.individuals.infrastructure.repository.PersonRepository;
import cesim.individuals.infrastructure.repository.models.PersonModel;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostgresUpdatePersonService implements UpdatePersonService {
  private final PersonRepository personRepository;

  public Person update(String id, Person person) {
    PersonModel existingModel = personRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));

    existingModel.setResource(person);
    PersonModel updatedModel = personRepository.save(existingModel);
    return updatedModel.getResource();
  }
}
