package cesim.individuals.presentation;

import cesim.individuals.domain.usecases.patient.*;
import org.springframework.web.bind.annotation.*;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.domain.entities.Patient;
import lombok.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {
  private final SearchPatientUsecase searchPatientUsecase;
  private final CreatePatientUsecase createPatientUsecase;
  private final UpdatePatientUsecase updatePatientUsecase;
  private final GetPatientByIdUsecase getPatientByIdUsecase;
  private final DeletePatientUsecase deletePatientUsecase;

  @GetMapping("/search")
  public CompletableFuture<Page<Patient>> searchPatients(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @RequestParam(defaultValue = "") String search) {
    return searchPatientUsecase.execute(new SearchPatientUsecase.Input(
                    new Pageable(page, size, sortBy, sortDirection), search))
            .thenApply(SearchPatientUsecase.Output::page);
  }

  @PostMapping("/")
  public CompletableFuture<Patient> createPatient(@RequestBody CreatePatientUsecase.Input input) {
    return createPatientUsecase.execute(input)
            .thenApply(CreatePatientUsecase.Output::patient);
  }

  @PatchMapping("/{id}")
  public CompletableFuture<Patient> updatePatient(
          @PathVariable String id,
          @RequestBody UpdatePatientUsecase.Input input) {
    return updatePatientUsecase.execute(new UpdatePatientUsecase.Input(id, input.patient()))
            .thenApply(UpdatePatientUsecase.Output::patient);
  }

  @GetMapping("/{id}")
  public CompletableFuture<Patient> getPatientById(@PathVariable String id) {
    return getPatientByIdUsecase.execute(new GetPatientByIdUsecase.Input(id))
            .thenApply(GetPatientByIdUsecase.Output::patient);
  }

  @DeleteMapping("/{id}")
  public CompletableFuture<String> deletePatient(@PathVariable String id) {
    return deletePatientUsecase.execute(new DeletePatientUsecase.Input(id))
            .thenApply(DeletePatientUsecase.Output::message);
  }
}
