package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.PatientRiskPriorityDTO;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public interface PatientRiskAssessmentService {
  Page<PatientRiskPriorityDTO> assessPatientsRisk(Pageable pageable);
}
