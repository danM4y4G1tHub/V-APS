package cesim.individuals.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import cesim.individuals.infrastructure.repository.models.RelatedPersonModel;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@Tag(
        name = "Related Persons",
        description = "The persons related patients"
)
@RepositoryRestResource(path = "related_persons")
public interface RelatedPersonRepository extends CrudRepository<RelatedPersonModel, String>, PagingAndSortingRepository<RelatedPersonModel, String> {
  @RestResource(exported = true)
  Page<RelatedPersonModel> findAll(Specification<RelatedPersonModel> spec, Pageable pageable);

  @RestResource()
  @Query(value =
          "SELECT * FROM related_persons p WHERE p.resource->'patient'->>'reference' = CONCAT('Patient/', :patientId)",
          nativeQuery = true)
  List<RelatedPersonModel> getByPatientId(@Param("patientId") String patientId);
}
