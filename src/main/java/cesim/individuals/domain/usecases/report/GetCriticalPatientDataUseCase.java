package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.CriticalPatientDataDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.GetCriticalPatientDataService;

import java.util.concurrent.CompletableFuture;

public class GetCriticalPatientDataUseCase implements Usecase<GetCriticalPatientDataUseCase.Input, GetCriticalPatientDataUseCase.Output> {
  final GetCriticalPatientDataService dataService;

  public GetCriticalPatientDataUseCase(GetCriticalPatientDataService dataService) {
    this.dataService = dataService;
  }

  @Override
  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      CriticalPatientDataDTO patientData = null;
      try {
        patientData = dataService.getCriticalDataByIdentification(request.CI());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return new Output(patientData);
    });
  }

  public record Input(String CI) {
  }

  public record Output(CriticalPatientDataDTO patientData) {
  }

  public static class ReportFilterUseCase {
  }
}
