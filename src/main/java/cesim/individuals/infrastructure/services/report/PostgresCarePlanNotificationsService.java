package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.CarePlan;
import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;
import cesim.individuals.domain.usecases.report.dependencies.CarePlanNotificationsService;
import cesim.individuals.infrastructure.repository.CarePlanRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.PractitionerRepository;
import cesim.individuals.infrastructure.repository.models.CarePlanModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import cesim.individuals.infrastructure.repository.models.PractitionerModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.*;

@Service
@RequiredArgsConstructor
public class PostgresCarePlanNotificationsService implements CarePlanNotificationsService {
  private final CarePlanRepository carePlanRepository;
  private final PatientRepository patientRepository;
  private final PractitionerRepository practitionerRepository;

  public List<CarePlanNotificationDTO> generateCarePlanClosureNotifications() {
    LocalDate today = LocalDate.now();
    List<CarePlanModel> carePlanModels = carePlanRepository.findActiveEndingToday(today.toString());

    return createCarePlanNotificationDTO(carePlanModels);
  }

  private List<CarePlanNotificationDTO> createCarePlanNotificationDTO(List<CarePlanModel> carePlanModels) {
    List<CarePlanNotificationDTO> notificationDTOS = carePlanModels.stream().
            map(cp -> {
              CarePlan carePlan = cp.getResource();
              String patientId = carePlan.subject().reference().split("/")[1];
              String practitionerId = carePlan.custodian().reference().split("/")[1];

              PatientModel patientModel = patientRepository.findById(patientId)
                      .orElseThrow(() ->
                              new IllegalArgumentException("Patient not found with id: " + patientId)
                      );

              PractitionerModel practitionerModel = practitionerRepository.findById(practitionerId)
                      .orElseThrow(() ->
                              new IllegalArgumentException("Practitioner not found with id:" + practitionerId));
              String patientName = patientModel.getResource().name().get(0).given().get(0);
              String lastName = patientModel.getResource().name().get(0).family();
              String message = "El plan de cuidado para " + patientName + lastName + " finaliza hoy. Pro favor revice seguimiento.";

              return new CarePlanNotificationDTO(
                      patientModel.getId(),
                      patientModel.getResource(),
                      practitionerModel.getResource(),
                      carePlan.period().end(),
                      message
              );
            }).collect(Collectors.toList());

    return notificationDTOS;
  }
}
