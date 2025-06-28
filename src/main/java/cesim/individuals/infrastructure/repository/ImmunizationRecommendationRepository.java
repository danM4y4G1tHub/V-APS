package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.ImmunizationRecommendationModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Tag(
        name = "ImmunizationRecommendation",
        description = "The immunization recommendations related service"
)
@RepositoryRestResource(path = "ImmunizationRecommendations")
public interface ImmunizationRecommendationRepository  extends JpaRepository<ImmunizationRecommendationModel, String>,
        JpaSpecificationExecutor<ImmunizationRecommendationModel>,
        CrudRepository<ImmunizationRecommendationModel, String>,
        PagingAndSortingRepository<ImmunizationRecommendationModel, String> {

  @RestResource()
  List<ImmunizationRecommendationModel> findAll();
}
