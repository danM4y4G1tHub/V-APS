package cesim.individuals.domain.usecases.patient;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.patient.dependencies.UpdatePatientService;

public class UpdatePatientUsecase implements Usecase<UpdatePatientUsecase.Input, UpdatePatientUsecase.Output> {
    final UpdatePatientService patientService;

    public UpdatePatientUsecase(UpdatePatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public CompletableFuture<UpdatePatientUsecase.Output> execute(UpdatePatientUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Patient updatedPatient = patientService.update(request.id(), request.patient());
            return new Output(updatedPatient);
        });
    }

    public static record Input(String id, Patient patient) {
    }

    public static record Output(Patient patient) {
    }
}
