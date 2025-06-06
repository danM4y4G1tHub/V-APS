package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.RecentEncounterDTO;
import cesim.individuals.domain.entities.report.specInput.RecentEncounterSpec;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public interface GetRecentEncounterService {
  Page<RecentEncounterDTO> getRecentEncounters(Pageable pageable, RecentEncounterSpec encounterSpec);
}
