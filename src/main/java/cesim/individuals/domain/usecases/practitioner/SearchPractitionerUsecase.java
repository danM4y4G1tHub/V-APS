package cesim.individuals.domain.usecases.practitioner;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Practitioner;

import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.practitioner.dependencies.SearchPractitionerService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public class SearchPractitionerUsecase implements Usecase<SearchPractitionerUsecase.Input, SearchPractitionerUsecase.Output> {
    final SearchPractitionerService practitionerService;

    public SearchPractitionerUsecase(SearchPractitionerService practitionerService) {
        this.practitionerService = practitionerService;
    }

    @Override
    public CompletableFuture<SearchPractitionerUsecase.Output> execute(SearchPractitionerUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Page<Practitioner> page = practitionerService.search(request.pageable(), request.query());
            return new Output(page);
        });
    }

    public static record Input(Pageable pageable, String query) {
    }

    public static record Output(Page<Practitioner> page) {
    }
}
