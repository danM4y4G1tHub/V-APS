package cesim.individuals.domain.usecases.person;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.person.dependencies.UpdatePersonService;

public class UpdatePersonUsecase implements Usecase<UpdatePersonUsecase.Input, UpdatePersonUsecase.Output> {
    final UpdatePersonService personService;

    public UpdatePersonUsecase(UpdatePersonService personService) {
        this.personService = personService;
    }

    @Override
    public CompletableFuture<UpdatePersonUsecase.Output> execute(UpdatePersonUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Person updatedPerson = personService.update(request.id(), request.person());
            return new Output(updatedPerson);
        });
    }

    public static record Input(String id, Person person) {
    }

    public static record Output(Person person) {
    }
}
