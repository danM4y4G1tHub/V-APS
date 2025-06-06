package cesim.individuals.application.notification;

import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;
import cesim.individuals.domain.usecases.report.GenerateCarePlanNotificationsUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class NotificationScheduler {
  private final GenerateCarePlanNotificationsUseCase generateCarePlanNotificationsUseCase;
  private final NotificationDispatcher notificationDispatcher;

  @Scheduled(cron = "0 0 8 * * ?")
  public void checkCarePlanClosures() {
    CompletableFuture<GenerateCarePlanNotificationsUseCase.Output> futureOutput =
            generateCarePlanNotificationsUseCase.execute(
                    new GenerateCarePlanNotificationsUseCase.Input()
            );

    futureOutput.thenAccept(output -> {
      for (CarePlanNotificationDTO carePlanNotificationDTO : output.notificationsDTO()) {
        try {
          notificationDispatcher.dispatch(carePlanNotificationDTO);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }).exceptionally(ex -> {
      System.out.println("Error while data collecting, detalis: " + ex.getMessage());
      ex.printStackTrace();
      return null;
    });
  }
}
