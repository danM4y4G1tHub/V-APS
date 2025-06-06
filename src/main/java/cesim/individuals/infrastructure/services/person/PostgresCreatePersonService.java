package cesim.individuals.infrastructure.services.person;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.person.dependencies.CreatePersonService;
import cesim.individuals.infrastructure.repository.PersonRepository;
import cesim.individuals.infrastructure.repository.models.PersonModel;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostgresCreatePersonService implements CreatePersonService {
  final PersonRepository personRepository;

  public Person create(Person person) {
    PersonModel model = PersonModel.builder()
            .resource(person)
            .status(PersonModel.Status.ACTIVE)
            .build();
    PersonModel savedModel = personRepository.save(model);
    return savedModel.getResource();
  }
}
