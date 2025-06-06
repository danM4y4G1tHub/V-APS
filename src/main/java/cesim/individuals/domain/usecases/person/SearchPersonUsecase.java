package cesim.individuals.domain.usecases.person;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.person.dependencies.SearchPersonService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public class SearchPersonUsecase implements Usecase<SearchPersonUsecase.Input, SearchPersonUsecase.Output> {
    final SearchPersonService personService;

    public SearchPersonUsecase(SearchPersonService personService) {
        this.personService = personService;
    }
    
    @Override
    public CompletableFuture<SearchPersonUsecase.Output> execute(SearchPersonUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Page<Person> page = personService.search(request.pageable(), request.query());
            return new Output(page);
        });
    }

    public static record Input(
            Pageable pageable,
            String query) {
    }

    public static record Output( 
            Page<Person> page) {
    }
}
