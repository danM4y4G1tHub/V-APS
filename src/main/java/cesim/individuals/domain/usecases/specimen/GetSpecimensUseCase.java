package cesim.individuals.domain.usecases.specimen;

import cesim.individuals.domain.entities.Specimen;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.specimen.dependencies.GetSpecimensService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class GetSpecimensUseCase implements Usecase<GetSpecimensUseCase.Input, GetSpecimensUseCase.Output> {
  final GetSpecimensService getSpecimensService;

  public GetSpecimensUseCase(GetSpecimensService getSpecimensService) {
    this.getSpecimensService = getSpecimensService;
  }

  public CompletableFuture<Output> execute(Input request) {
    return CompletableFuture.supplyAsync(() -> {
      Page<Specimen> specimens = getSpecimensService
              .getSpecimensAfterDate(request.pageable(), request.afterDate());
      return new Output(specimens);
    });
  }

  public record Input(Pageable pageable, LocalDateTime afterDate) {
  }

  public record Output(Page<Specimen> specimenPage) {
  }
}
