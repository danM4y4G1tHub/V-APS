package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.Condition;
import cesim.individuals.domain.entities.Observation;
import cesim.individuals.domain.entities.report.outputDTO.PatientRiskPriorityDTO;
import cesim.individuals.domain.usecases.report.dependencies.PatientRiskAssessmentService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.ObservationRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.ConditionModel;
import cesim.individuals.infrastructure.repository.models.ObservationModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresPatientRiskAssessmentService implements PatientRiskAssessmentService {

  private static final Map<String, Integer> CONDITION_WEIGHTS = Map.of(
          "44054006", 30,   // Diabetes
          "38341003", 25,   // Hipertensión
          "195967001", 20,  // Asma
          "8517006", 40     // Enfermedad coronaria
  );

  private final PatientRepository patientRepository;
  private final ConditionRepository conditionRepository;
  private final ObservationRepository observationRepository;

  private String determinateRiskLevel(int score) {
    return (score >= 70) ? "Alto" : (score >= 40) ? "Medio" : "Bajo";
  }

  @Override
  public Page<PatientRiskPriorityDTO> assessPatientsRisk(Pageable pageable) {
    var sort = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var patientResults = patientRepository.findAll(PageRequest.of(
            pageable.page(),
            pageable.size(),
            sort
    ));

    List<PatientModel> patientModels = patientResults.getContent();
    List<String> patientIds = patientModels.stream()
            .map(PatientModel::getId)
            .collect(Collectors.toList());

    List<PatientRiskPriorityDTO> riskPriorities = patientModels.stream()
            .map(patient -> {
              String patientId = patient.getId();

              List<Condition> conditions = mapConditionsByPatient(patientIds).getOrDefault(
                              patientId, List.of()).stream().map(ConditionModel::getResource)
                      .collect(Collectors.toList());

              List<Observation> observations = mapObservationsByPatient(patientIds).getOrDefault(
                              patientId, List.of()).stream().map(ObservationModel::getResource)
                      .collect(Collectors.toList());

              int score = calculateRiskScore(conditions, observations);
              String riskLevel = determinateRiskLevel(score);

              return new PatientRiskPriorityDTO(patient.getResource(), score, riskLevel);
            }).sorted(Comparator.comparingInt(PatientRiskPriorityDTO::riskScore).reversed())
            .collect(Collectors.toList());

    return new Page<>(
            patientResults.getNumber(),
            patientResults.getSize(),
            patientResults.getTotalPages(),
            riskPriorities
    );
  }

  private int calculateRiskScore(List<Condition> conditions, List<Observation> observations) {
    int score = 0;

    for (Condition condition : conditions) {
      String code = condition.code().coding().get(0).code();
      score += CONDITION_WEIGHTS.getOrDefault(code, 10);
    }

    for (Observation observation : observations) {
      if ("abnormal".equals(observation.interpretation().get(0).coding().get(0).code())) {
        score += 15;
      }
    }

    return score;
  }

  private Map<String, List<ConditionModel>> mapConditionsByPatient(List<String> patientIds) {
    return conditionRepository.findByPatientIds(patientIds).stream().collect(
            Collectors.groupingBy(condition ->
                    condition.getResource().subject().reference().split("/")[1]
            ));
  }

  private Map<String, List<ObservationModel>> mapObservationsByPatient(List<String> patientIds) {
    return observationRepository.findByPatientIds(patientIds).stream()
            .collect(Collectors.groupingBy(
                    observation -> observation.getResource()
                            .subject().reference().split("/")[0]
            ));
  }
}
