package cesim.individuals.application.report;

import cesim.individuals.application.notification.NotificationScheduler;
import cesim.individuals.domain.entities.report.outputDTO.MonthlyStatisticsReportDTO;
import cesim.individuals.domain.usecases.report.GenerateStatisticsReportUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  private static final Logger logger = LoggerFactory.getLogger(ReportScheduler.class);

  @Scheduled(cron = "0 0 9 28 * ?")
  public void generateMonthlyReport() {
    logger.info("\uD83D\uDD04 Executing scheduled task: generateMonthlyReport");

    YearMonth previousMonth = YearMonth.now().minusMonths(1);
    CompletableFuture<GenerateStatisticsReportUseCase.Output> futureOuput = reportUseCase.execute(
            new GenerateStatisticsReportUseCase.Input(previousMonth)
    );

    futureOuput.thenAccept(output -> {
      try {
        MonthlyStatisticsReportDTO report = output.reportDTO();

        logger.info("✅ Reporte generado: {}", report.getClass().getName());

        reportExporter.exportReport(report);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        logger.error("⚠️ Exportación de reporte interrumpida", e);
      } catch (Exception e){
        logger.error("⛔ Error exportando reporte", e);
      }
    }).exceptionally(ex -> {
      logger.error("⛔ Error generando reporte estadístico", ex);
      return null;
    });
  }
}
