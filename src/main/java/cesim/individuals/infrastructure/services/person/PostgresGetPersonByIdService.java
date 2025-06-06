package cesim.individuals.infrastructure.services.person;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.person.dependencies.GetPersonByIdService;
import cesim.individuals.infrastructure.repository.PersonRepository;
import cesim.individuals.infrastructure.repository.models.PersonModel;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostgresGetPersonByIdService implements GetPersonByIdService {
  private final PersonRepository personRepository;

  public Person getById(String id) {
    PersonModel model = personRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));
    return model.getResource();
  }
}
