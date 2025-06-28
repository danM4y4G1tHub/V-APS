package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.OrganizationModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Tag(
        name = "Organizations",
        description = "The organizations related service"
)
@RepositoryRestResource(path = "Organizations")
public interface OrganizationRepository extends JpaRepository<OrganizationModel, String>,
JpaSpecificationExecutor<OrganizationModel>,
CrudRepository<OrganizationModel, String>,
        PagingAndSortingRepository<OrganizationModel, String> {

  @Query(value = "SELECT o.resource->>'name' AS policlinico, COUNT(p.id) AS medicos " +
          "FROM practitioners p " +
          "LEFT JOIN organizations o ON o.id = split_part(p.resource->'issuer'->>'reference', '/', 2) " +
          "GROUP BY o.resource->>'name', p.id",
          nativeQuery = true)
  Page<Object[]> countDoctorsByClinic(Pageable pageable);
}
