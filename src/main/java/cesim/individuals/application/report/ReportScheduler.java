package cesim.individuals.application.report;

import cesim.individuals.domain.entities.report.outputDTO.MonthlyStatisticsReportDTO;
import cesim.individuals.domain.usecases.report.GenerateStatisticsReportUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.*;

import java.time.YearMonth;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class ReportScheduler {
  private final GenerateStatisticsReportUseCase reportUseCase;
  private final ReportExporter reportExporter;

  @Scheduled(cron = "0 0 9 28 * ?")
  public void generateMonthlyReport() {
    YearMonth previousMonth = YearMonth.now().minusMonths(1);
    CompletableFuture<MonthlyStatisticsReportDTO> futureOuput = reportUseCase.execute(
            new GenerateStatisticsReportUseCase.Input(previousMonth)
    );

    futureOuput.thenAccept(report -> {
      try {
        reportExporter.exportReport(report);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).exceptionally(ex -> {
      ex.printStackTrace();
      return null;
    });
  }
}
