package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.specInput.AdvancedSearchRequestSpec;
import cesim.individuals.domain.entities.report.outputDTO.AdvancedSearchResultsDTO;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.AdvancedSearchService;
import cesim.individuals.domain.utils.Pageable;

import java.util.concurrent.CompletableFuture;

public class AdvancedSearchUseCase implements Usecase<AdvancedSearchUseCase.Input, AdvancedSearchUseCase.Output> {
  final AdvancedSearchService advancedSearchService;

  public AdvancedSearchUseCase(AdvancedSearchService advancedSearchService) {
    this.advancedSearchService = advancedSearchService;
  }

  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      AdvancedSearchResultsDTO resultsDTO = advancedSearchService.searchPatients(
              request.pageable(),
              request.searchRequest()
      );

      return new Output(resultsDTO);
    });
  }

  public record Input(Pageable pageable, AdvancedSearchRequestSpec searchRequest) {
  }

  public record Output(AdvancedSearchResultsDTO resultsDTO) {
  }
}
