package cesim.individuals.presentation;

import org.springframework.web.bind.annotation.*;
import cesim.individuals.domain.usecases.*;
import cesim.individuals.domain.usecases.practitioner.CreatePractitionerUsecase;
import cesim.individuals.domain.usecases.practitioner.DeletePractitionerUsecase;
import cesim.individuals.domain.usecases.practitioner.GetPractitionerByIdUsecase;
import cesim.individuals.domain.usecases.practitioner.SearchPractitionerUsecase;
import cesim.individuals.domain.usecases.practitioner.UpdatePractitionerUsecase;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.domain.entities.Practitioner;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/practitioners")
@RequiredArgsConstructor
public class PractitionerController {
    private final SearchPractitionerUsecase searchPractitionerUsecase;
    private final CreatePractitionerUsecase createPractitionerUsecase;
    private final UpdatePractitionerUsecase updatePractitionerUsecase;
    private final GetPractitionerByIdUsecase getPractitionerByIdUsecase;
    private final DeletePractitionerUsecase deletePractitionerUsecase;

    @GetMapping("/search")
    public CompletableFuture<Page<Practitioner>> searchPractitioners(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "") String search) {
        return searchPractitionerUsecase.execute(new SearchPractitionerUsecase.Input(
                new Pageable(page, size, sortBy, sortDirection), search))
                .thenApply(SearchPractitionerUsecase.Output::page);
    }

    @PostMapping("/")
    public CompletableFuture<Practitioner> createPractitioner(@RequestBody CreatePractitionerUsecase.Input input) {
        return createPractitionerUsecase.execute(input)
                .thenApply(CreatePractitionerUsecase.Output::practitioner);
    }

    @PatchMapping("/{id}")
    public CompletableFuture<Practitioner> updatePractitioner(
            @PathVariable String id,
            @RequestBody UpdatePractitionerUsecase.Input input) {
        return updatePractitionerUsecase.execute(new UpdatePractitionerUsecase.Input(id, input.practitioner()))
                .thenApply(UpdatePractitionerUsecase.Output::practitioner);
    }

    @GetMapping("/{id}")
    public CompletableFuture<Practitioner> getPractitionerById(@PathVariable String id) {
        return getPractitionerByIdUsecase.execute(new GetPractitionerByIdUsecase.Input(id))
                .thenApply(GetPractitionerByIdUsecase.Output::practitioner);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> deletePractitioner(@PathVariable String id) {
        return deletePractitionerUsecase.execute(new DeletePractitionerUsecase.Input(id))
                .thenApply(DeletePractitionerUsecase.Output::message);
    }
}
