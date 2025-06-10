package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.CommunityReportDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.CommunityReportService;

import java.util.concurrent.CompletableFuture;

public class GenerateCommunityReportUseCase implements Usecase<GenerateCommunityReportUseCase.Input,
        GenerateCommunityReportUseCase.Output> {
  final CommunityReportService reportService;

  public GenerateCommunityReportUseCase(CommunityReportService reportService) {
    this.reportService = reportService;
  }

  public CompletableFuture<Output> execute(Input request){
    return CompletableFuture.supplyAsync(() -> {
      CommunityReportDTO reportDTO = reportService.generateCommunityReport(request.communityId());

      return new Output(reportDTO);
    });
  }

  public record Input(String communityId){}
  public record Output(CommunityReportDTO reportDTO){}
}
