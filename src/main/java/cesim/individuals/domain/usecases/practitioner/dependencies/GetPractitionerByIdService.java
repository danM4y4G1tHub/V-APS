package cesim.individuals.domain.usecases.practitioner.dependencies;

import cesim.individuals.domain.entities.Practitioner;

public interface GetPractitionerByIdService {
    Practitioner getById(String id);
}
