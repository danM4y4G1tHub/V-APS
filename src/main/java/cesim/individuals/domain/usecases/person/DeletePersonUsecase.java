package cesim.individuals.domain.usecases.person;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.person.dependencies.DeletePersonService;

public class DeletePersonUsecase implements Usecase<DeletePersonUsecase.Input, DeletePersonUsecase.Output> {
    final DeletePersonService personService;

    public DeletePersonUsecase(DeletePersonService personService) {
        this.personService = personService;
    }

    @Override
    public CompletableFuture<DeletePersonUsecase.Output> execute(DeletePersonUsecase.Input request) {
        return CompletableFuture.runAsync(() -> personService.delete(request.id()))
                .thenApply(v -> new Output("person with ID " + request.id() + " deleted successfully."));
    }

    public static record Input(String id) {
    }

    public static record Output(String message) {
    }
}
