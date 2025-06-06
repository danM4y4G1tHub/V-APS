package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.MonthlyStatisticsReportDTO;

import java.time.YearMonth;

public interface StatisticsReportService {
  MonthlyStatisticsReportDTO generateMonthlyReport(YearMonth month);
}
