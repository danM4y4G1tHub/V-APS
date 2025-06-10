package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.CDRReportDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.CommunityReportService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GenerateCDRReportsUseCase  implements Usecase<GenerateCDRReportsUseCase.Input,
        GenerateCDRReportsUseCase.Output> {
  final CommunityReportService reportService;

  public GenerateCDRReportsUseCase(CommunityReportService reportService) {
    this.reportService = reportService;
  }

  public CompletableFuture<Output> execute(Input request){
    return CompletableFuture.supplyAsync(() -> {
      List<CDRReportDTO> reportDTO = reportService.generateCDRReports(request.communityId());
      return new Output(reportDTO);
    });
  }

  public record Input(String communityId){}
  public record Output(List<CDRReportDTO> reportDTO){}
}
