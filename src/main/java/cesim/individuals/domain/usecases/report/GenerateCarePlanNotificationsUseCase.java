package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.CarePlanNotificationsService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GenerateCarePlanNotificationsUseCase implements
        Usecase<GenerateCarePlanNotificationsUseCase.Input,
                GenerateCarePlanNotificationsUseCase.Output> {
  final CarePlanNotificationsService notificationService;

  public GenerateCarePlanNotificationsUseCase(CarePlanNotificationsService notificationService) {
    this.notificationService = notificationService;
  }

  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      List<CarePlanNotificationDTO> notificationsDTO = notificationService
              .generateCarePlanClosureNotifications();

      return new Output(notificationsDTO);
    });
  }

  public record Input() {
  }

  public record Output(List<CarePlanNotificationDTO> notificationsDTO) {
  }
}
