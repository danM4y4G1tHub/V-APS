package cesim.individuals.infrastructure.services.relatedPerson;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.GetRelatedPersonByIdService;
import cesim.individuals.infrastructure.repository.RelatedPersonRepository;
import cesim.individuals.infrastructure.repository.models.RelatedPersonModel;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresGetRelatedPersonByIdService implements GetRelatedPersonByIdService {
  private final RelatedPersonRepository relatedPersonRepository;

  @Override
  public RelatedPerson getById(String id) {
    RelatedPersonModel model = relatedPersonRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("RelatedPerson not found with id: " + id));
    return model.getResource();
  }
}
