package cesim.individuals.domain.usecases.relatedPerson;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.GetRelatedPersonByIdService;

public class GetRelatedPersonByIdUsecase implements Usecase<GetRelatedPersonByIdUsecase.Input, GetRelatedPersonByIdUsecase.Output> {
    final GetRelatedPersonByIdService relatedPersonService;

    public GetRelatedPersonByIdUsecase(GetRelatedPersonByIdService relatedPersonService) {
        this.relatedPersonService = relatedPersonService;
    }

    @Override
    public CompletableFuture<GetRelatedPersonByIdUsecase.Output> execute(GetRelatedPersonByIdUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            RelatedPerson relatedPerson = relatedPersonService.getById(request.id());
            return new Output(relatedPerson);
        });
    }

    public static record Input(String id) {
    }

    public static record Output(RelatedPerson relatedPerson) {
    }
}
