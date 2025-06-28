package cesim.individuals.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import cesim.individuals.infrastructure.repository.models.PersonModel;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(
        name = "Persons",
        description = "The persons related service"
)
@RepositoryRestResource(path = "persons")
public interface PersonRepository extends CrudRepository<PersonModel, String>, PagingAndSortingRepository<PersonModel, String> {
  @RestResource(exported = true)
  Page<PersonModel> findAll(Specification<PersonModel> spec, Pageable pageable);
}
