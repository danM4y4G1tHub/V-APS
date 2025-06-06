package cesim.individuals.domain.usecases.relatedPerson;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.SearchRelatedPersonService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public class SearchRelatedPersonUsecase implements Usecase<SearchRelatedPersonUsecase.Input, SearchRelatedPersonUsecase.Output> {
    final SearchRelatedPersonService relatedPersonService;

    public SearchRelatedPersonUsecase(SearchRelatedPersonService relatedPersonService) {
        this.relatedPersonService = relatedPersonService;
    }

    @Override
    public CompletableFuture<SearchRelatedPersonUsecase.Output> execute(SearchRelatedPersonUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Page<RelatedPerson> page = relatedPersonService.search(request.pageable(), request.query());
            return new Output(page);
        });
    }

    public static record Input(Pageable pageable, String query) {
    }

    public static record Output(Page<RelatedPerson> page) {
    }
}
