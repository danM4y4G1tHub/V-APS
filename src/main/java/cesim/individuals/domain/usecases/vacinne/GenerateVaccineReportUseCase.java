package cesim.individuals.domain.usecases.vacinne;

import cesim.individuals.domain.entities.vaccine.VaccineReportDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.vacinne.depenencies.VaccineManagementService;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

public class GenerateVaccineReportUseCase implements Usecase<GenerateVaccineReportUseCase.Input,
        GenerateVaccineReportUseCase.Output> {
  final VaccineManagementService managementService;

  public GenerateVaccineReportUseCase(VaccineManagementService managementService) {
    this.managementService = managementService;
  }

  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      VaccineReportDTO reportDTO = managementService.generateVaccineReport(request.reportDate());

      return new Output(reportDTO);
    });
  }

  public record Input(LocalDate reportDate) {
  }

  public record Output(VaccineReportDTO reportDTO) {
  }
}
