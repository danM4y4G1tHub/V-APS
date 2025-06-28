package cesim.individuals.domain.usecases.patient;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.patient.dependencies.SearchPatientService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public class SearchPatientUsecase implements Usecase<SearchPatientUsecase.Input, SearchPatientUsecase.Output> {
    final SearchPatientService patientService;

    public SearchPatientUsecase(SearchPatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public CompletableFuture<SearchPatientUsecase.Output> execute(SearchPatientUsecase.Input request) {
        return CompletableFuture.supplyAsync(() -> {
            Page<Patient> page = patientService.search(request.pageable(), request.query());
            return new Output(page);
        });
    }

    public static record Input(Pageable pageable, String query) {
    }

    public static record Output(Page<Patient> page) {
    }
}
