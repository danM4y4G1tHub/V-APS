package cesim.individuals.domain.usecases.practitioner;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Practitioner;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.practitioner.dependencies.CreatePractitionerService;

public class CreatePractitionerUsecase implements Usecase<CreatePractitionerUsecase.Input, CreatePractitionerUsecase.Output> {
    final CreatePractitionerService practitionerService;

    public CreatePractitionerUsecase(CreatePractitionerService practitionerService) {
        this.practitionerService = practitionerService;
    }

    @Override
    public CompletableFuture<CreatePractitionerUsecase.Output> execute(CreatePractitionerUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Practitioner createdPractitioner = practitionerService.create(request.practitioner());
            return new Output(createdPractitioner);
        });
    }

    public static record Input(Practitioner practitioner) {
    }

    public static record Output(Practitioner practitioner) {
    }
}
