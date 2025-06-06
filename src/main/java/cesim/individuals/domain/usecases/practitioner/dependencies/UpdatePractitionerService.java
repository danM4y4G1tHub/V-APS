package cesim.individuals.domain.usecases.practitioner.dependencies;

import cesim.individuals.domain.entities.Practitioner;

public interface UpdatePractitionerService {
    Practitioner update(String id, Practitioner practitioner);
}
