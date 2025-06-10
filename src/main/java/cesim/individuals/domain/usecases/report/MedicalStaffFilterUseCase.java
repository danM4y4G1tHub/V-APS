package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.MedicalStaffCountDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.MedicalStaffFilterService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

import java.util.concurrent.CompletableFuture;

public class MedicalStaffFilterUseCase implements Usecase<MedicalStaffFilterUseCase.Input,
        MedicalStaffFilterUseCase.Output> {

  final MedicalStaffFilterService filterService;

  public MedicalStaffFilterUseCase(MedicalStaffFilterService filterService) {
    this.filterService = filterService;
  }

  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      Page<MedicalStaffCountDTO> resultsDTO = filterService.countDoctorsByClinic(request.pageable());
              return new Output(resultsDTO);
            }
    );
  }

  public record Input(Pageable pageable) {
  }

  public record Output(Page<MedicalStaffCountDTO> resultsDTO) {
  }
}
