package cesim.individuals.domain.usecases.patient.dependencies;

import cesim.individuals.domain.entities.Patient;

public interface UpdatePatientService {
    Patient update(String id, Patient patient);
}
