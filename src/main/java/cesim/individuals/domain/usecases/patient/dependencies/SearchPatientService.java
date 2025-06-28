package cesim.individuals.domain.usecases.patient.dependencies;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public interface SearchPatientService {
    Page<Patient> search(Pageable pageable, String query);
}
