package cesim.individuals.domain.usecases.patient.dependencies;

import cesim.individuals.domain.entities.Patient;

public interface GetPatientByIdService {
    Patient getById(String id);
}