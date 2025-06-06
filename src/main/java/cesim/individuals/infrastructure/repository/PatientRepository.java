package cesim.individuals.infrastructure.repository;

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

import cesim.individuals.infrastructure.repository.models.PatientModel;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Optional;

@Tag(
        name = "Patients",
        description = "The patients related service"
)
@RepositoryRestResource(path = "Patients")
public interface PatientRepository extends JpaRepository<PatientModel, String>,
        JpaSpecificationExecutor<PatientModel>, CrudRepository<PatientModel, String>, PagingAndSortingRepository<PatientModel, String> {
  @RestResource(exported = true)
  Page<PatientModel> findAll(Specification<PatientModel> spec, Pageable pageable);

  @RestResource()
  @Query(value = "SELECT * FROM patients p where p.resource->'identifier'->0->>'value' = :identifier",
          nativeQuery = true)
  Optional<PatientModel> findByIdentication(@Param("identifier") String identifier);
}
