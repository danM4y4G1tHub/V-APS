package cesim.individuals.domain.usecases.person;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.Usecase;
import cesim.individuals.domain.usecases.person.dependencies.CreatePersonService;

import java.util.concurrent.CompletableFuture;

public class CreatePersonUsecase implements Usecase<CreatePersonUsecase.Input, CreatePersonUsecase.Output> {
  final CreatePersonService personService;

  public CreatePersonUsecase(CreatePersonService personService) {
    this.personService = personService;
  }

  @Override
  public CompletableFuture<CreatePersonUsecase.Output> execute(CreatePersonUsecase.Input request) {
    return CompletableFuture.supplyAsync(() -> {
      Person createdPerson = personService.create(request.person());
      return new Output(createdPerson);
    });
  }

  public record Input(Person person) {
  }

  public record Output(Person person) {
  }
}
