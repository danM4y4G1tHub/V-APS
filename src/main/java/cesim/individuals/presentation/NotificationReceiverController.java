package cesim.individuals.presentation;

import cesim.individuals.application.notification.NotificationScheduler;
import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/notifications")
public class NotificationReceiverController {
  private NotificationScheduler notificationScheduler;

  @PostMapping("/trig-notification")
  public String receiveNotification(@RequestBody CarePlanNotificationDTO notification) {
    System.out.println("Notification received successfully");
    System.out.println("Patient " + notification.patient().name().get(0).family());
    System.out.println("Practitioner " + notification.practitioner().name().get(0).given());
    System.out.println("Message: " + notification.notificationMessage());
    System.out.println("End date: " + notification.endDate());
    notificationScheduler.checkCarePlanClosures();
    return "Notification received successfully";
  }
}
