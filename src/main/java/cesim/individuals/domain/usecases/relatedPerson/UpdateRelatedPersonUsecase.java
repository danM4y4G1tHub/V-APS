package cesim.individuals.domain.usecases.relatedPerson;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.UpdateRelatedPersonService;

public class UpdateRelatedPersonUsecase implements Usecase<UpdateRelatedPersonUsecase.Input, UpdateRelatedPersonUsecase.Output> {
    final UpdateRelatedPersonService relatedPersonService;

    public UpdateRelatedPersonUsecase(UpdateRelatedPersonService relatedPersonService) {
        this.relatedPersonService = relatedPersonService;
    }

    @Override
    public CompletableFuture<UpdateRelatedPersonUsecase.Output> execute(UpdateRelatedPersonUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            RelatedPerson updatedRelatedPerson = relatedPersonService.update(request.id(), request.relatedPerson());
            return new Output(updatedRelatedPerson);
        });
    }

    public static record Input(String id, RelatedPerson relatedPerson) {
    }

    public static record Output(RelatedPerson relatedPerson) {
    }
}
