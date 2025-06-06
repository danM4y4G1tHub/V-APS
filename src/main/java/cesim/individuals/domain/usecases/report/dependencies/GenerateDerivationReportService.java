package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.DerivationReportDTO;

public interface GenerateDerivationReportService {
  DerivationReportDTO generateDerivationReport(String patientId);
}
