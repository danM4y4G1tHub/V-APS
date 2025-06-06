package cesim.individuals.domain.usecases.relatedPerson;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.DeleteRelatedPersonService;

public class DeleteRelatedPersonUsecase implements Usecase<DeleteRelatedPersonUsecase.Input, DeleteRelatedPersonUsecase.Output> {
    final DeleteRelatedPersonService relatedPersonService;

    public DeleteRelatedPersonUsecase(DeleteRelatedPersonService relatedPersonService) {
        this.relatedPersonService = relatedPersonService;
    }

    @Override
    public CompletableFuture<DeleteRelatedPersonUsecase.Output> execute(DeleteRelatedPersonUsecase.Input request) {
        return CompletableFuture.runAsync(() -> relatedPersonService.delete(request.id()))
                .thenApply(v -> new Output("RelatedPerson with ID " + request.id() + " deleted successfully."));
    }

    public static record Input(String id) {
    }

    public static record Output(String message) {
    }
}
