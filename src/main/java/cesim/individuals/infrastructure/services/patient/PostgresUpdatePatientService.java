package cesim.individuals.infrastructure.services.patient;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.usecases.patient.dependencies.UpdatePatientService;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.PatientModel;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresUpdatePatientService implements UpdatePatientService {
  private final PatientRepository patientRepository;

  @Override
  public Patient update(String id, Patient patient) {
    PatientModel existingModel = patientRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Patient not found with id: " + id));

    existingModel.setResource(patient);
    PatientModel updatedModel = patientRepository.save(existingModel);
    return updatedModel.getResource();
  }
}
