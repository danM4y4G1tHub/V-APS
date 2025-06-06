package cesim.individuals.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import cesim.individuals.infrastructure.repository.models.PractitionerModel;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
        name = "Pratitioners",
        description = "The practitioners related service"
)
@RepositoryRestResource(path = "practitioners")
public interface PractitionerRepository extends
        JpaRepository<PractitionerModel, String>,
        JpaSpecificationExecutor<PractitionerModel>,
        CrudRepository<PractitionerModel, String>,
        PagingAndSortingRepository<PractitionerModel, String> {
  @RestResource(exported = true)
  Page<PractitionerModel> findAll(Specification<PractitionerModel> spec, Pageable pageable);
}
