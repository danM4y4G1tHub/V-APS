package cesim.individuals.domain.usecases.patient;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.patient.dependencies.GetPatientByIdService;

public class GetPatientByIdUsecase implements Usecase<GetPatientByIdUsecase.Input, GetPatientByIdUsecase.Output> {
    final GetPatientByIdService patientService;

    public GetPatientByIdUsecase(GetPatientByIdService patientService) {
        this.patientService = patientService;
    }

    @Override
    public CompletableFuture<GetPatientByIdUsecase.Output> execute(GetPatientByIdUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Patient patient = patientService.getById(request.id());
            return new Output(patient);
        });
    }

    public static record Input(String id) {
    }

    public static record Output(Patient patient) {
    }
}
