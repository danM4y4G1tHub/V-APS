package cesim.individuals.infrastructure.services.relatedPerson;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.UpdateRelatedPersonService;
import cesim.individuals.infrastructure.repository.RelatedPersonRepository;
import cesim.individuals.infrastructure.repository.models.RelatedPersonModel;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresUpdateRelatedPersonService implements UpdateRelatedPersonService {
  private final RelatedPersonRepository relatedPersonRepository;

  @Override
  public RelatedPerson update(String id, RelatedPerson relatedPerson) {
    RelatedPersonModel existingModel = relatedPersonRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("RelatedPerson not found with id: " + id));

    existingModel.setResource(relatedPerson);
    RelatedPersonModel updatedModel = relatedPersonRepository.save(existingModel);
    return updatedModel.getResource();
  }
}
