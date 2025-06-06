package cesim.individuals.infrastructure.services.relatedPerson;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.CreateRelatedPersonService;
import cesim.individuals.infrastructure.repository.RelatedPersonRepository;
import cesim.individuals.infrastructure.repository.models.RelatedPersonModel;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresCreateRelatedPersonService implements CreateRelatedPersonService {
  private final RelatedPersonRepository relatedPersonRepository;

  @Override
  public RelatedPerson create(RelatedPerson relatedPerson) {
    RelatedPersonModel model = RelatedPersonModel.builder()
            .resource(relatedPerson)
            .status(RelatedPersonModel.Status.ACTIVE)
            .build();
    RelatedPersonModel savedModel = relatedPersonRepository.save(model);
    return savedModel.getResource();
  }
}
