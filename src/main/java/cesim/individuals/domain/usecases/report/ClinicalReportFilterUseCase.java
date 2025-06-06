package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.ClinicalReportDTO;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.ClinicalReportFilterService;
import cesim.individuals.domain.utils.Pageable;

import java.util.concurrent.CompletableFuture;

public class ClinicalReportFilterUseCase implements Usecase<ClinicalReportFilterUseCase.Input, ClinicalReportFilterUseCase.Output> {
  final ClinicalReportFilterService filterService;

  public ClinicalReportFilterUseCase(ClinicalReportFilterService filterService) {
    this.filterService = filterService;
  }

  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
              ClinicalReportDTO clinicalReportsDTO = filterService.filterConditions(request.pageable(), request.filterSpec());
              return new Output(clinicalReportsDTO);
            }
    );
  }

  public record Input(Pageable pageable, ClinicalReportFilterSpec filterSpec) {
  }

  public record Output(ClinicalReportDTO clinicalReportDTO) {
  }
}
