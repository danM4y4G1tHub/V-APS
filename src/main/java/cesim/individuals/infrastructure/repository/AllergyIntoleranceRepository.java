package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.AllergyIntoleranceModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Tag(
        name = "AllergyIntolerances",
        description = "The allergy intolerances related service"
)
@RepositoryRestResource(path = "AllergyIntolerances")
public interface AllergyIntoleranceRepository extends CrudRepository<AllergyIntoleranceModel, String> {
  @RestResource()
  @Query(value =
          "SELECT * FROM allergy_intolerances a WHERE a.resource->'patient'->>'reference' = CONCAT('Patient/', :patientId)",
          nativeQuery = true)
  List<AllergyIntoleranceModel> findByPatientId(@Param("patientId") String patientId);
}
