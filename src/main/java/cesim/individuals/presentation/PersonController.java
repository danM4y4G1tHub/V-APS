package cesim.individuals.presentation;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.person.CreatePersonUsecase;
import cesim.individuals.domain.usecases.person.DeletePersonUsecase;
import cesim.individuals.domain.usecases.person.GetPersonByIdUsecase;
import cesim.individuals.domain.usecases.person.SearchPersonUsecase;
import cesim.individuals.domain.usecases.person.UpdatePersonUsecase;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@Tag(name = "Persons", description = "The persons related service", externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(description = "FHIR Code System Documentation", url = "https://www.hl7.org/fhir/codesystem.html"))
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final SearchPersonUsecase searchPersonUsecase;
    private final CreatePersonUsecase createPersonUsecase;
    private final UpdatePersonUsecase updatePersonUsecase;
    private final GetPersonByIdUsecase getPersonByIdUsecase;
    private final DeletePersonUsecase deletePersonUsecase;

    @GetMapping("/search")
    public CompletableFuture<Page<Person>> getMethodName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "") String search) {
        return searchPersonUsecase
                .execute(new SearchPersonUsecase.Input(new Pageable(page, size, sortBy, sortDirection), search))
                .thenApply(SearchPersonUsecase.Output::page);
    }

    @PostMapping("/")
    public CompletableFuture<Person> createPerson(CreatePersonUsecase.Input input) {
        return createPersonUsecase
                .execute(input)
                .thenApply(CreatePersonUsecase.Output::person);
    }

    @PatchMapping("/{id}")
    public CompletableFuture<Person> updatePerson(UpdatePersonUsecase.Input input) {
        return updatePersonUsecase
                .execute(input)
                .thenApply(UpdatePersonUsecase.Output::person);
    }

    @GetMapping("/{id}")
    public CompletableFuture<Person> getPersonById(@RequestParam String id) {
        return getPersonByIdUsecase
                .execute(new GetPersonByIdUsecase.Input(id))
                .thenApply(GetPersonByIdUsecase.Output::person);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> deletePerson(@RequestParam String id) {
        return deletePersonUsecase
                .execute(new DeletePersonUsecase.Input(id))
                .thenApply(DeletePersonUsecase.Output::message);
    }
}
