package cesim.individuals.infrastructure.services.patient;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.usecases.patient.dependencies.GetPatientByIdService;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.PatientModel;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresGetPatientByIdService implements GetPatientByIdService {
    private final PatientRepository patientRepository;

    @Override
    public Patient getById(String id) {
        PatientModel model = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with id: " + id));
        return model.getResource();
    }
}
