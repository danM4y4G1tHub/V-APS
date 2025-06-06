package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.DerivationReportDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.GenerateDerivationReportService;

import java.util.concurrent.CompletableFuture;

public class GenerateDerivationReportUsecase implements
        Usecase<GenerateDerivationReportUsecase.Input, GenerateDerivationReportUsecase.Output> {
  final GenerateDerivationReportService reportService;

  public GenerateDerivationReportUsecase(GenerateDerivationReportService reportService) {
    this.reportService = reportService;
  }

  @Override
  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      DerivationReportDTO reportDTO = reportService.generateDerivationReport(request.patienId());
      return new Output(reportDTO);
    });
  }

  public record Input(String patienId) {
  }

  public record Output(DerivationReportDTO derivationReport) {
  }
}
