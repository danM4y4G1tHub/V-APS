package cesim.individuals.domain.usecases.practitioner;

import java.util.concurrent.CompletableFuture;


import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.practitioner.dependencies.DeletePractitionerService;

public class DeletePractitionerUsecase implements Usecase<DeletePractitionerUsecase.Input, DeletePractitionerUsecase.Output> {
    final DeletePractitionerService practitionerService;

    public DeletePractitionerUsecase(DeletePractitionerService practitionerService) {
        this.practitionerService = practitionerService;
    }

    @Override
    public CompletableFuture<DeletePractitionerUsecase.Output> execute(DeletePractitionerUsecase.Input request) {
        return CompletableFuture.runAsync(() -> practitionerService.delete(request.id()))
                .thenApply(v -> new Output("Practitioner with ID " + request.id() + " deleted successfully."));
    }

    public static record Input(String id) {
    }

    public static record Output(String message) {
    }
}
