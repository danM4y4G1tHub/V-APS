package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.AbsenceReportDTO;
import cesim.individuals.domain.entities.report.specInput.AbsenceTrackingSpec;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.AbsenceTrackingService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

import java.util.concurrent.CompletableFuture;

public class GenerateAbsenceTrackingReportUseCase implements Usecase<GenerateAbsenceTrackingReportUseCase.Input,
        GenerateAbsenceTrackingReportUseCase.OutPut> {
  final AbsenceTrackingService trackingService;

  public GenerateAbsenceTrackingReportUseCase(AbsenceTrackingService trackingService) {
    this.trackingService = trackingService;
  }

  @Override
  public CompletableFuture<OutPut> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
              Page<AbsenceReportDTO> reportDTO = trackingService.findAbsences(
                      request.pageable(), request.spec()
              );
              return new OutPut(reportDTO);
    });
  }

  public record Input(Pageable pageable, AbsenceTrackingSpec spec){}

  public record OutPut(Page<AbsenceReportDTO> reportDTO){}
}
