package cesim.individuals.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import cesim.individuals.infrastructure.repository.models.ObservationModel;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Observations", description = "The observations related service")
@RepositoryRestResource(path = "Observations")
public interface ObservationRepository extends CrudRepository<ObservationModel, String>,
                PagingAndSortingRepository<ObservationModel, String> {
        @RestResource()
        @Query(value = "SELECT o.* FROM observations o " +
                        "WHERE o.resource->'encounter'->>'reference' = CONCAT('Encounter/', :encounterId)"
                , nativeQuery = true)
        List<ObservationModel> findByEncounterId(@Param("encounterId") String encounterId);

        @RestResource()
        @Query(value = "SELECT * FROM observations o " +
                        "WHERE o.resource->'subject'->>'reference' " +
                        "LIKE 'Patient/%' AND split_part(o.resource->'subject'->>'reference',  '/', 2) IN :patientIds", nativeQuery = true)
        List<ObservationModel> findByPatientIds(@Param("patientIds") List<String> patientIds);

        @RestResource()
        @Query(value = "SELECT * FROM observations o " +
                        "WHERE o.resource->'subject'->>'reference' " +
                        "LIKE 'Patient/%' AND split_part(o.resource->'subject'->>'reference', '/', 2) IN :patientIds " +
                        "AND o.resource->'effectiveDateTime'->>'value' BETWEEN :startDate AND :endDate " +
                        "AND o.resource->'code'->'coding' @> '[{\"code\":\"77386006\"}]'", nativeQuery = true)
        List<ObservationModel> findPregnancyObservations(
                        @Param("patientIds") List<String> patientIds,
                        @Param("startDate") String startDate,
                        @Param("endDate") String endDate);

        @RestResource()
        @Query(value = "SELECT * FROM observations o " +
                        "WHERE o.resource->'context'->>'reference' = :locationId " +
                        "AND o.resource->'code'->'coding'->0->>'code' = :code", nativeQuery = true)
        List<ObservationModel> findByLocationAndCode(
                        @Param("locationId") String locationId,
                        @Param("code") String code);
}
