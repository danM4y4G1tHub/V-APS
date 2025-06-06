package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;

import java.util.List;

public interface CarePlanNotificationsService {
  List<CarePlanNotificationDTO> generateCarePlanClosureNotifications();
}
