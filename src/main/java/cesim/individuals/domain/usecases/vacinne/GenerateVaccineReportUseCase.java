package cesim.individuals.domain.usecases.vacinne;

import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.vacinne.depenencies.VaccineManagementService;

import java.util.concurrent.CompletableFuture;

public class GenerateVaccineReportUseCase implements Usecase<GenerateVaccineReportUseCase.Input,
        GenerateVaccineReportUseCase.Output> {
  final VaccineManagementService managementService;

  public GenerateVaccineReportUseCase(VaccineManagementService managementService) {
    this.managementService = managementService;
  }

  public CompletableFuture<Output> execute(Input request) {
    return null;
  }

  public record Input() {
  }

  public record Output() {
  }
}
