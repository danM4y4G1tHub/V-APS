package cesim.individuals.infrastructure.services.relatedPerson;

import cesim.individuals.domain.usecases.relatedPerson.dependencies.DeleteRelatedPersonService;
import cesim.individuals.infrastructure.repository.RelatedPersonRepository;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresDeleteRelatedPersonService implements DeleteRelatedPersonService {
  private final RelatedPersonRepository relatedPersonRepository;

  @Override
  public void delete(String id) {
    if (!relatedPersonRepository.existsById(id)) {
      throw new IllegalArgumentException("RelatedPerson not found with id: " + id);
    }
    relatedPersonRepository.deleteById(id);
  }
}
