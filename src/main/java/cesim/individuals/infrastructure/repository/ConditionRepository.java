package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.ConditionModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Tag(
        name = "Conditions",
        description = "The conditions related service"
)
@RepositoryRestResource(path = "Conditions")
public interface ConditionRepository extends JpaRepository<ConditionModel, String>,
        JpaSpecificationExecutor<ConditionModel>,
        CrudRepository<ConditionModel, String>,
        PagingAndSortingRepository<ConditionModel, String> {
  @RestResource()
  @Query(value =
          "SELECT * FROM conditions c WHERE c.resource->'subject'->>'reference' = CONCAT('Patient/', :patientId)",
          nativeQuery = true)
  List<ConditionModel> findByPatientId(@Param("patientId") String patientId);

  @RestResource()
  @Query(value =
          "SELECT * FROM conditions c " +
                  "WHERE c.resource->'subject'->>'reference' " +
                  "LIKE 'Patient/%' " +
                  "AND split_part(c.resource->'subject'->>'reference', '/', 2) IN :patientIds",
          nativeQuery = true)
  List<ConditionModel> findByPatientIds(@Param("patientIds") List<String> patientIds);

  @RestResource()
  @Query(value = "SELECT * FROM conditions c " +
          "WHERE c.resource->>'recordedDate' BETWEEN :startDate AND :endDate",
          nativeQuery = true)
  List<ConditionModel> findByRecordedDate(
          @Param("startDate") String startDate,
          @Param("endDate") String endDate);

  @RestResource()
  Page<ConditionModel> findAll(Specification<ConditionModel> spec, Pageable pageable);
}
