package cesim.individuals.infrastructure.services.practitioner;

import cesim.individuals.domain.entities.Practitioner;
import cesim.individuals.domain.usecases.practitioner.dependencies.CreatePractitionerService;
import cesim.individuals.infrastructure.repository.PractitionerRepository;
import cesim.individuals.infrastructure.repository.models.PractitionerModel;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostgresCreatePractitionerService implements CreatePractitionerService {
    private final PractitionerRepository practitionerRepository;

    @Override
    public Practitioner create(Practitioner practitioner) {
        PractitionerModel model = PractitionerModel.builder()
                .resource(practitioner)
                .status(PractitionerModel.Status.ACTIVE)
                .build();
        PractitionerModel savedModel = practitionerRepository.save(model);
        return savedModel.getResource();
    }
}
