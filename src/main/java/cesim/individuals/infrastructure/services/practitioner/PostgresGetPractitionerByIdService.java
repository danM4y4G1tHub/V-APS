package cesim.individuals.infrastructure.services.practitioner;

import cesim.individuals.domain.entities.Practitioner;
import cesim.individuals.domain.usecases.practitioner.dependencies.GetPractitionerByIdService;
import cesim.individuals.infrastructure.repository.PractitionerRepository;
import cesim.individuals.infrastructure.repository.models.PractitionerModel;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresGetPractitionerByIdService implements GetPractitionerByIdService {
  private final PractitionerRepository practitionerRepository;

  @Override
  public Practitioner getById(String id) {
    PractitionerModel model = practitionerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Practitioner not found with id: " + id));
    return model.getResource();
  }
}
