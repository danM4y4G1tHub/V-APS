package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.ClinicalReportDTO;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.utils.Pageable;

public interface ClinicalReportFilterService {
  ClinicalReportDTO filterConditions(Pageable pageable, ClinicalReportFilterSpec filterSpec);
}
