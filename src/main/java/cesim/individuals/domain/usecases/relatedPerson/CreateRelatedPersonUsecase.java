package cesim.individuals.domain.usecases.relatedPerson;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.CreateRelatedPersonService;

public class CreateRelatedPersonUsecase implements Usecase<CreateRelatedPersonUsecase.Input, CreateRelatedPersonUsecase.Output> {
    final CreateRelatedPersonService relatedPersonService;

    public CreateRelatedPersonUsecase(CreateRelatedPersonService relatedPersonService) {
        this.relatedPersonService = relatedPersonService;
    }

    @Override
    public CompletableFuture<CreateRelatedPersonUsecase.Output> execute(CreateRelatedPersonUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            RelatedPerson createdRelatedPerson = relatedPersonService.create(request.relatedPerson());
            return new Output(createdRelatedPerson);
        });
    }

    public static record Input(RelatedPerson relatedPerson) {
    }

    public static record Output(RelatedPerson relatedPerson) {
    }
}
