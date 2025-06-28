package cesim.individuals.infrastructure.repository;


import cesim.individuals.infrastructure.repository.models.SpecimenModel;
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

import java.time.LocalDateTime;

@Tag(
        name = "Specimens",
        description = "The specimens related service"
)
@RepositoryRestResource(path = "Specimens")
public interface SpecimenRepository extends JpaRepository<SpecimenModel, String>,
        JpaSpecificationExecutor<SpecimenModel>, CrudRepository<SpecimenModel, String>,
        PagingAndSortingRepository<SpecimenModel, String> {
  @RestResource()
  @Query(value = "SELECT * FROM specimens e " +
          "WHERE e.resource->'collection'->>'collectedDateTime' > :afterDate"
          , nativeQuery = true)
  Page<SpecimenModel> findByCollectionDateAfter(
          @Param("afterDate") LocalDateTime afterDate, Pageable pageable);
}
