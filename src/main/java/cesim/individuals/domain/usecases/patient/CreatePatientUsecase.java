package cesim.individuals.domain.usecases.patient;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.patient.dependencies.CreatePatientService;

public class CreatePatientUsecase implements Usecase<CreatePatientUsecase.Input, CreatePatientUsecase.Output> {
    final CreatePatientService patientService;

    public CreatePatientUsecase(CreatePatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public CompletableFuture<CreatePatientUsecase.Output> execute(CreatePatientUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Patient createdPatient = patientService.create(request.patient());
            return new Output(createdPatient);
        });
    }

    public static record Input(Patient patient) {
    }

    public static record Output(Patient patient) {
    }
}
