package cesim.individuals.infrastructure.services.patient;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.usecases.patient.dependencies.CreatePatientService;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.PatientModel;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresCreatePatientService implements CreatePatientService {
    private final PatientRepository patientRepository;

    @Override
    public Patient create(Patient patient) {
        PatientModel model = PatientModel.builder()
                .resource(patient)
                .status(PatientModel.Status.ACTIVE)
                .build();
        PatientModel savedModel = patientRepository.save(model);
        return savedModel.getResource();
    }
}
