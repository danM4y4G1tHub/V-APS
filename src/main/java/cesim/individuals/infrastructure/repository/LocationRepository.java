package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.LocationModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Tag(
        name = "Locations",
        description = "The locations related service"
)
@RepositoryRestResource(path = "Locations")
public interface LocationRepository  extends JpaRepository<LocationModel, String>,
        JpaSpecificationExecutor<LocationModel>,
        CrudRepository<LocationModel, String>,
        PagingAndSortingRepository<LocationModel, String> {

  @Resource()
  @Query(value = "SELECT * FROM locations l " +
          "WHERE l.resource->'identifier'->>'value' = '%cdr%' " +
          "AND l.resource->'partOf'->>'reference' = CONCAT('Location/', :communityId)",
          nativeQuery = true)
  List<LocationModel> findCDRByCommunity(@Param("communityId") String communityId);
}
