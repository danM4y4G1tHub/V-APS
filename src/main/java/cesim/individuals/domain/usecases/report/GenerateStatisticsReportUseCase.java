package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.MonthlyStatisticsReportDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.StatisticsReportService;

import java.time.YearMonth;
import java.util.concurrent.CompletableFuture;

public class GenerateStatisticsReportUseCase implements Usecase<GenerateStatisticsReportUseCase.Input,
        GenerateStatisticsReportUseCase.Output> {
  final StatisticsReportService reportService;

  public GenerateStatisticsReportUseCase(StatisticsReportService reportService) {
    this.reportService = reportService;
  }

  @Override
  public CompletableFuture execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      MonthlyStatisticsReportDTO reportDTO = reportService.generateMonthlyReport(request.month);

      return new Output(reportDTO);
    });
  }

  public record Input(YearMonth month) {
  }

  public record Output(MonthlyStatisticsReportDTO reportDTO) {
  }
}
