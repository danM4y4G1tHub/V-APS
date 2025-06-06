package cesim.individuals.infrastructure.services.person;

import cesim.individuals.domain.usecases.person.dependencies.DeletePersonService;
import cesim.individuals.infrastructure.repository.PersonRepository;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostgresDeletePersonService implements DeletePersonService {
  private final PersonRepository personRepository;

  public void delete(String id) {
    if (!personRepository.existsById(id)) {
      throw new IllegalArgumentException("person not found with id: " + id);
    }
    personRepository.deleteById(id);
  }
}
