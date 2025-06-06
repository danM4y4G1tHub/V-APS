package cesim.individuals.infrastructure.services.relatedPerson;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cesim.individuals.domain.entities.RelatedPerson;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.SearchRelatedPersonService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.RelatedPersonRepository;
import cesim.individuals.infrastructure.repository.models.RelatedPersonModel;
import cesim.individuals.infrastructure.repository.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;

import lombok.*;
import org.springframework.data.domain.PageRequest;

@Service
@RequiredArgsConstructor
public class PostgresSearchRelatedPersonService implements SearchRelatedPersonService {
  private final RelatedPersonRepository relatedPersonRepository;

  @Override
  public Page<RelatedPerson> search(Pageable pageable, String query) {
    Specification<RelatedPersonModel> spec = Specification.where(null);

    if (query != null && !query.isEmpty()) {
      var rootNode = new RSQLParser().parse(query);
      spec = rootNode.accept(new CustomRsqlVisitor<>());
    }

    var sort = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var results = relatedPersonRepository.findAll(spec, PageRequest.of(
            pageable.page(),
            pageable.size(),
            sort));

    return new Page<>(
            results.getNumber(),
            results.getSize(),
            results.getTotalPages(),
            results.toList().stream().map(RelatedPersonModel::getResource).toList());
  }
}
