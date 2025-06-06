package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.MedicationRequestModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Tag(
        name = "MedicationsRequest",
        description = "The medications request related service"
)
@RepositoryRestResource(path = "MedicationsRequest")
public interface MedicationRequestRepository extends CrudRepository<MedicationRequestModel, String> {
  @RestResource()
  @Query(value =
          "SELECT * FROM medication_requests m WHERE m.resource->'subject'->>'reference' = CONCAT('Patient/', :patientId)",
          nativeQuery = true)
  List<MedicationRequestModel> findByPatientId(@Param("patientId") String patientId);
}
