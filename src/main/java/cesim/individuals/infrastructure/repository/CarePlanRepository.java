package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.CarePlanModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Tag(
        name = "CarePlans",
        description = "The care plans related service"
)
@RepositoryRestResource(path = "CarePlans")
public interface CarePlanRepository extends CrudRepository<CarePlanModel, String>,
        PagingAndSortingRepository<CarePlanModel, String> {

  @RestResource(exported = true)
  @Query(value =
          "SELECT * FROM care_plans c " +
          "WHERE c.resource->'subject'->>'reference' = CONCAT('Patient/', :patientId)",
          nativeQuery = true
  )
  List<CarePlanModel> findByPatientId(@Param("patientId") String patientId);

  @RestResource(exported = true)
  @Query(value =
          "SELECT * FROM care_plans cp " +
          "WHERE cp.resource->'status' = 'active' " +
          "AND cp.resource->'period'->>end = :endDate"
          , nativeQuery = true)
  List<CarePlanModel> findActiveEndingToday(@Param("endDate") String endDate);
}
