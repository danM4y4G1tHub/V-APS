package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.EncounterModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;
import java.util.List;

@Tag(
        name = "Encounters",
        description = "The encounters related service"
)
@RepositoryRestResource(path = "Encounters")
public interface EncounterRepository extends JpaRepository<EncounterModel, String>,
        JpaSpecificationExecutor<EncounterModel>,
        CrudRepository<EncounterModel, String>,
        PagingAndSortingRepository<EncounterModel, String> {
  @RestResource()
  @Query(value =
          "SELECT * FROM encounters e " +
                  "WHERE e.resource->'subject'->>'reference' = CONCAT('Patient/', :patientId)",
          nativeQuery = true)
  List<EncounterModel> findByPatientId(@Param("patientId") String patientId);

  @RestResource()
  @Query(value =
          "SELECT * FROM encounters e " +
                  "WHERE EXISTS ( " +
                  "  SELECT 1 FROM jsonb_array_elements(e.resource->'participant') AS p " +
                  "  WHERE p->'individual'->>'reference' = :practitionerRef " +
                  ") " +
                  "AND CAST(e.resource->'actualPeriod'->>'start' AS TIMESTAMP) " +
                  "BETWEEN :startDate AND :endDate",
          nativeQuery = true)
  Page<EncounterModel> findByPractitionerAndDateRange(
          @Param("practitionerRef") String practitionerRef,
          @Param("startDate") Date startDate,
          @Param("endDate") Date endDate,
          Pageable pageable
  );

  @RestResource()
  @Query(value = "SELECT * FROM encounters e " +
          "WHERE e.resource->'period'->>'start' BETWEEN :startDate AND :endDate",
          nativeQuery = true)
  List<EncounterModel> findByDateBetween(
          @Param("startDate") String startDate,
          @Param("endDate") String endDate);
}
