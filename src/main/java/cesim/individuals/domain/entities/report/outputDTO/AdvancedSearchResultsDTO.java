package cesim.individuals.domain.entities.report.outputDTO;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.utils.Page;

public record AdvancedSearchResultsDTO(
        Page<Patient> patientPage
) {
}
