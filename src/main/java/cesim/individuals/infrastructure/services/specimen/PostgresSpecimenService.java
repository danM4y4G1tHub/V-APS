package cesim.individuals.infrastructure.services.specimen;

import cesim.individuals.domain.entities.Specimen;
import cesim.individuals.domain.usecases.specimen.dependencies.GetSpecimensService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.SpecimenRepository;
import cesim.individuals.infrastructure.repository.models.SpecimenModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostgresSpecimenService implements GetSpecimensService {
  private final SpecimenRepository specimenRepository;

  public Page<Specimen> getSpecimensAfterDate(Pageable pageable, LocalDateTime afterDate) {
    var sort = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var specimenResults = specimenRepository.findByCollectionDateAfter(afterDate, PageRequest.of(
            pageable.page(),
            pageable.size(),
            sort));

    List<Specimen> specimens = specimenResults.items().stream().map(
            SpecimenModel::getResource).toList();

    return new Page<>(
            specimenResults.pageNumber(),
            specimenResults.pageSize(),
            specimenResults.totalPages(),
            specimens
    );
  }
}
