package cesim.individuals.infrastructure.services.patient;

import cesim.individuals.domain.usecases.patient.dependencies.DeletePatientService;
import cesim.individuals.infrastructure.repository.PatientRepository;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresDeletePatientService implements DeletePatientService {
  private final PatientRepository patientRepository;

  @Override
  public void delete(String id) {
    if (!patientRepository.existsById(id)) {
      throw new IllegalArgumentException("Patient not found with id: " + id);
    }
    patientRepository.deleteById(id);
  }
}
