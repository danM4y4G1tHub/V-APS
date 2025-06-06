package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.specInput.AdvancedSearchRequestSpec;
import cesim.individuals.domain.entities.report.outputDTO.AdvancedSearchResultsDTO;
import cesim.individuals.domain.utils.Pageable;

public interface AdvancedSearchService {
  AdvancedSearchResultsDTO searchPatients(Pageable pageable, AdvancedSearchRequestSpec searchRequest);
}
