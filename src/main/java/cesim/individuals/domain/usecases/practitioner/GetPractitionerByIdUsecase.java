package cesim.individuals.domain.usecases.practitioner;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Practitioner;

import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.practitioner.dependencies.GetPractitionerByIdService;

public class GetPractitionerByIdUsecase implements Usecase<GetPractitionerByIdUsecase.Input, GetPractitionerByIdUsecase.Output> {
    final GetPractitionerByIdService practitionerService;

    public GetPractitionerByIdUsecase(GetPractitionerByIdService practitionerService) {
        this.practitionerService = practitionerService;
    }

    @Override
    public CompletableFuture<GetPractitionerByIdUsecase.Output> execute(GetPractitionerByIdUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Practitioner practitioner = practitionerService.getById(request.id());
            return new Output(practitioner);
        });
    }

    public static record Input(String id) {
    }

    public static record Output(Practitioner practitioner) {
    }
}
