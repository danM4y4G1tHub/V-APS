package cesim.individuals.application.notification;

import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.springframework.http.*;

@Component
public class NotificationDispatcher {
  private static final int MAX_RETRIES = 3;
  private static final Logger logger = LoggerFactory.getLogger(NotificationDispatcher.class);
  private final RestTemplate restTemplate;
  private final String notificationUrl;
  private final String authToken;

  public NotificationDispatcher(
          RestTemplate restTemplate,
          @Value("${notification.api.url}") String notificationUrl,
          @Value("${notification.api.token}") String authToken
  ) {
    this.restTemplate = restTemplate;
    this.notificationUrl = notificationUrl;
    this.authToken = authToken;
  }

  public void dispatch(CarePlanNotificationDTO notification) throws InterruptedException {
    int retryCount = 0;

    while (retryCount < MAX_RETRIES) {
      try {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);

        HttpEntity<CarePlanNotificationDTO> request = new HttpEntity<>(notification, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                notificationUrl, HttpMethod.POST, request, String.class
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
          System.out.println("Notification error: " + response.getBody());
        }
        return;
      } catch (Exception e) {
        retryCount++;
        Thread.sleep(5000);
        logger.error("Error sending notification: " + e.getMessage());
      }
    }
  }
}
