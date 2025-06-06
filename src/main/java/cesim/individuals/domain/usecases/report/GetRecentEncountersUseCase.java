package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.RecentEncounterDTO;
import cesim.individuals.domain.entities.report.specInput.RecentEncounterSpec;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.report.dependencies.GetRecentEncounterService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

import java.util.concurrent.CompletableFuture;

public class GetRecentEncountersUseCase implements Usecase<GetRecentEncountersUseCase.Input,
        GetRecentEncountersUseCase.Output> {
  final GetRecentEncounterService encounterService;

  public GetRecentEncountersUseCase(GetRecentEncounterService encounterService) {
    this.encounterService = encounterService;
  }

  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
              Page<RecentEncounterDTO> encounterDTO = encounterService.
                      getRecentEncounters(request.pageable(), request.encounterSpec());
              return new Output(encounterDTO);
            }
    );
  }

  public record Input(Pageable pageable, RecentEncounterSpec encounterSpec) {
  }

  public record Output(Page<RecentEncounterDTO> encounterDTO) {
  }
}
