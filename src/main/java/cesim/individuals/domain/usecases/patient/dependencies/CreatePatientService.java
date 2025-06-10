package cesim.individuals.domain.usecases.patient.dependencies;

import cesim.individuals.domain.entities.Patient;

public interface CreatePatientService {
    Patient create(Patient patient);
}
