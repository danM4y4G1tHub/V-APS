package cesim.individuals.infrastructure.services.practitioner;

import cesim.individuals.domain.usecases.practitioner.dependencies.DeletePractitionerService;
import cesim.individuals.infrastructure.repository.PractitionerRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostgresDeletePractitionerService implements DeletePractitionerService {
    private final PractitionerRepository practitionerRepository;

    @Override
    public void delete(String id) {
        if (!practitionerRepository.existsById(id)) {
            throw new IllegalArgumentException("Practitioner not found with id: " + id);
        }
        practitionerRepository.deleteById(id);
    }
}
