package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.ImmunizationModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Tag(
        name = "Immunizations",
        description = "The immunizations related service"
)
@RepositoryRestResource(path = "Immunizations")
public interface ImmunizationRepository extends JpaRepository<ImmunizationModel, String>,
        JpaSpecificationExecutor<ImmunizationModel>,
        CrudRepository<ImmunizationModel, String>,
        PagingAndSortingRepository<ImmunizationModel, String> {

}
