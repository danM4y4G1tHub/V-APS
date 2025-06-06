package cesim.individuals.domain.usecases.practitioner;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Practitioner;

import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.practitioner.dependencies.UpdatePractitionerService;

public class UpdatePractitionerUsecase implements Usecase<UpdatePractitionerUsecase.Input, UpdatePractitionerUsecase.Output> {
    final UpdatePractitionerService practitionerService;

    public UpdatePractitionerUsecase(UpdatePractitionerService practitionerService) {
        this.practitionerService = practitionerService;
    }

    @Override
    public CompletableFuture<UpdatePractitionerUsecase.Output> execute(UpdatePractitionerUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Practitioner updatedPractitioner = practitionerService.update(request.id(), request.practitioner());
            return new Output(updatedPractitioner);
        });
    }

    public static record Input(String id, Practitioner practitioner) {
    }

    public static record Output(Practitioner practitioner) {
    }
}
