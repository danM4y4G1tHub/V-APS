package cesim.individuals.presentation;

import org.springframework.web.bind.annotation.*;

import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.domain.entities.RelatedPerson;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

import cesim.individuals.domain.usecases.relatedPerson.CreateRelatedPersonUsecase;
import cesim.individuals.domain.usecases.relatedPerson.DeleteRelatedPersonUsecase;
import cesim.individuals.domain.usecases.relatedPerson.GetRelatedPersonByIdUsecase;
import cesim.individuals.domain.usecases.relatedPerson.SearchRelatedPersonUsecase;
import cesim.individuals.domain.usecases.relatedPerson.UpdateRelatedPersonUsecase;

@RestController
@RequestMapping("/api/v1/related_persons")
@RequiredArgsConstructor
public class RelatedPersonController {
    private final SearchRelatedPersonUsecase searchRelatedPersonUsecase;
    private final CreateRelatedPersonUsecase createRelatedPersonUsecase;
    private final UpdateRelatedPersonUsecase updateRelatedPersonUsecase;
    private final GetRelatedPersonByIdUsecase getRelatedPersonByIdUsecase;
    private final DeleteRelatedPersonUsecase deleteRelatedPersonUsecase;

    @GetMapping("/search")
    public CompletableFuture<Page<RelatedPerson>> searchRelatedPersons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "") String search) {
        return searchRelatedPersonUsecase.execute(new SearchRelatedPersonUsecase.Input(
                new Pageable(page, size, sortBy, sortDirection), search))
                .thenApply(SearchRelatedPersonUsecase.Output::page);
    }

    @PostMapping("/")
    public CompletableFuture<RelatedPerson> createRelatedPerson(@RequestBody CreateRelatedPersonUsecase.Input input) {
        return createRelatedPersonUsecase.execute(input)
                .thenApply(CreateRelatedPersonUsecase.Output::relatedPerson);
    }

    @PatchMapping("/{id}")
    public CompletableFuture<RelatedPerson> updateRelatedPerson(
            @PathVariable String id,
            @RequestBody UpdateRelatedPersonUsecase.Input input) {
        return updateRelatedPersonUsecase.execute(new UpdateRelatedPersonUsecase.Input(id, input.relatedPerson()))
                .thenApply(UpdateRelatedPersonUsecase.Output::relatedPerson);
    }

    @GetMapping("/{id}")
    public CompletableFuture<RelatedPerson> getRelatedPersonById(@PathVariable String id) {
        return getRelatedPersonByIdUsecase.execute(new GetRelatedPersonByIdUsecase.Input(id))
                .thenApply(GetRelatedPersonByIdUsecase.Output::relatedPerson);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> deleteRelatedPerson(@PathVariable String id) {
        return deleteRelatedPersonUsecase.execute(new DeleteRelatedPersonUsecase.Input(id))
                .thenApply(DeleteRelatedPersonUsecase.Output::message);
    }
}
