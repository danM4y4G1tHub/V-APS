package cesim.individuals.application.notification;

import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;
import cesim.individuals.domain.entities.report.outputDTO.Test.CarePlanNotificationDTOTest;
import cesim.individuals.domain.entities.report.outputDTO.Test.HumanNameDTO;
import cesim.individuals.domain.entities.report.outputDTO.Test.PatientDTO;
import cesim.individuals.domain.entities.report.outputDTO.Test.PractitionerDTO;
import cesim.individuals.domain.usecases.report.GenerateCarePlanNotificationsUseCase;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class NotificationScheduler {
  private final GenerateCarePlanNotificationsUseCase generateCarePlanNotificationsUseCase;
  private final NotificationDispatcher notificationDispatcher;
  private static final Logger logger = LoggerFactory.getLogger(NotificationScheduler.class);

  @Scheduled(cron = "0 0 8 * * ?")
  public void checkCarePlanClosures() {
    logger.info("\uD83D\uDD04 Executing scheduled task: checkCarePlanClosures");

    processNotifications();
  }

  private void processNotifications(){
    logger.info("\uD83D\uDD0D Searching pending notifications...");

    CompletableFuture<GenerateCarePlanNotificationsUseCase.Output> futureOutput =
            generateCarePlanNotificationsUseCase.execute(
                    new GenerateCarePlanNotificationsUseCase.Input()
            );

    futureOutput.thenAccept(output -> {
      logger.info("\uD83D\uDCE8 {} notifications founded to send",
              output.notificationsDTO().size()
      );

      for (CarePlanNotificationDTO carePlanNotificationDTO : output.notificationsDTO()) {
        try {
          logger.info("✉\uFE0F Sending notification to: {}",
                  carePlanNotificationDTO.patient().name().get(0).family()
          );

          notificationDispatcher.dispatch(carePlanNotificationDTO);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();

          logger.error("⛔ Sent interrupted: {}", e.getMessage());
        }
      }
    }).exceptionally(ex -> {
      logger.error("⛔ Error processing notifications: {}", ex.getMessage());
      ex.printStackTrace();
      return null;
    });
  }

//  @PostConstruct
//  public void onStartup(){
//    sendTestNotification();
//  }
//
//  private void sendTestNotification(){
//    System.out.println("Enviando notificación de prueba al iniciar...");
//    CarePlanNotificationDTOTest testNotification = new CarePlanNotificationDTOTest(
//            new PatientDTO(
//                    "Test Patient",
//                    List.of(
//                            new HumanNameDTO(List.of("Family"), List.of("Given"))
//                    )
//            ),
//            new PractitionerDTO(
//                    "Test Practitioner",
//                    List.of(
//                            new HumanNameDTO(List.of("Doc"), List.of("John"))
//                    )
//            ),
//            "Aplicación Spring Boot iniciada correctamente",
//            LocalDate.now().minusDays(7)
//    );
//
//    try {
//      notificationDispatcher.dispatchOnStartUp(testNotification);
//    } catch (InterruptedException e) {
//      Thread.currentThread().interrupt();
//      System.err.println("Envío de prueba interrumpido: " + e.getMessage());
//    }
//  }
}
