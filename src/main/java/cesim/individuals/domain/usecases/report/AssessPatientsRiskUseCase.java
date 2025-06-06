package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.PatientRiskPriorityDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.PatientRiskAssessmentService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

import java.util.concurrent.CompletableFuture;

public class AssessPatientsRiskUseCase implements Usecase<AssessPatientsRiskUseCase.Input, AssessPatientsRiskUseCase.Output> {
  final PatientRiskAssessmentService assessmentService;

  public AssessPatientsRiskUseCase(PatientRiskAssessmentService assessmentService) {
    this.assessmentService = assessmentService;
  }

  @Override
  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      Page<PatientRiskPriorityDTO> patientRiskPriorityDTO = assessmentService.assessPatientsRisk(
              request.pageable()
      );

      return new Output(patientRiskPriorityDTO);
    });
  }

  public record Input(Pageable pageable) {
  }

  public record Output(Page<PatientRiskPriorityDTO> riskPriorities) {
  }
}
