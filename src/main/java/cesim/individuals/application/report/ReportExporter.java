package cesim.individuals.application.report;

import cesim.individuals.application.notification.NotificationDispatcher;
import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;
import cesim.individuals.domain.entities.report.outputDTO.MonthlyStatisticsReportDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReportExporter {
  private static final int MAX_RETRIES = 3;
  private static final Logger logger = LoggerFactory.getLogger(ReportExporter.class);
  private final RestTemplate restTemplate;
  private final String reportStatisticUrl;
  private final String authToken;

  public ReportExporter(RestTemplate restTemplate,
                        @Value("${reportStatisticUrl.api.url}") String reportStatisticUrl,
                        @Value("${reportStatistic.api.token}") String authToken) {
    this.authToken = authToken;
    this.restTemplate = restTemplate;
    this.reportStatisticUrl = reportStatisticUrl;
  }

  public void exportReport(MonthlyStatisticsReportDTO reportDTO) throws InterruptedException {
    int retryCount = 0;

    while (retryCount < MAX_RETRIES) {
      try {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);

        HttpEntity<MonthlyStatisticsReportDTO> request = new HttpEntity<>(reportDTO, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                reportStatisticUrl, HttpMethod.POST, request, String.class
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
          System.out.println("Monthly Statistics Report error: " + response.getBody());
        }
        return;
      } catch (Exception ex) {
        retryCount++;
        Thread.sleep(5000);
        logger.error("Errer sending Monthly Statistics Report: " + ex.getMessage());
      }
    }
  }
}
