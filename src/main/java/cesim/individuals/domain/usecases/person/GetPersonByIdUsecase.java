package cesim.individuals.domain.usecases.person;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.person.dependencies.GetPersonByIdService;

public class GetPersonByIdUsecase implements Usecase<GetPersonByIdUsecase.Input, GetPersonByIdUsecase.Output> {
    final GetPersonByIdService personService;

    public GetPersonByIdUsecase(GetPersonByIdService personService) {
        this.personService = personService;
    }

    @Override
    public CompletableFuture<GetPersonByIdUsecase.Output> execute(GetPersonByIdUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Person person = personService.getById(request.id());
            return new Output(person);
        });
    }

    public static record Input(String id) {
    }

    public static record Output(Person person) {
    }
}
