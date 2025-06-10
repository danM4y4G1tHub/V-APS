package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.CDRReportDTO;
import cesim.individuals.domain.entities.report.outputDTO.CommunityReportDTO;

import java.util.List;

public interface CommunityReportService {
  CommunityReportDTO generateCommunityReport(String communityId);
  List<CDRReportDTO> generateCDRReports(String communityId);
}
