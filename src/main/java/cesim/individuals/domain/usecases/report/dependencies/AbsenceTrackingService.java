package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.AbsenceReportDTO;
import cesim.individuals.domain.entities.report.specInput.AbsenceTrackingSpec;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public interface AbsenceTrackingService {
  Page<AbsenceReportDTO> findAbsences( Pageable pageable, AbsenceTrackingSpec spec);
}
