package cesim.individuals.infrastructure.services.practitioner;

import cesim.individuals.domain.entities.Practitioner;
import cesim.individuals.domain.usecases.practitioner.dependencies.UpdatePractitionerService;
import cesim.individuals.infrastructure.repository.PractitionerRepository;
import cesim.individuals.infrastructure.repository.models.PractitionerModel;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostgresUpdatePractitionerService implements UpdatePractitionerService {
    private final PractitionerRepository practitionerRepository;

    @Override
    public Practitioner update(String id, Practitioner practitioner) {
        PractitionerModel existingModel = practitionerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Practitioner not found with id: " + id));

        existingModel.setResource(practitioner);
        PractitionerModel updatedModel = practitionerRepository.save(existingModel);
        return updatedModel.getResource();
    }
}
