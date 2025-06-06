package cesim.individuals.domain.usecases.patient;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.patient.dependencies.DeletePatientService;

public class DeletePatientUsecase implements Usecase<DeletePatientUsecase.Input, DeletePatientUsecase.Output> {
    final DeletePatientService patientService;

    public DeletePatientUsecase(DeletePatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public CompletableFuture<DeletePatientUsecase.Output> execute(DeletePatientUsecase.Input request) {
        return CompletableFuture.runAsync(() -> patientService.delete(request.id()))
                .thenApply(v -> new Output("Patient with ID " + request.id() + " deleted successfully."));
    }

    public static record Input(String id) {
    }

    public static record Output(String message) {
    }
}
