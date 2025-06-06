package cesim.individuals.infrastructure.services.person;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.PersonRepository;
import cesim.individuals.infrastructure.repository.models.PersonModel;
import cesim.individuals.infrastructure.repository.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import lombok.*;

import org.springframework.data.domain.PageRequest;

import cesim.individuals.domain.entities.Person;
import cesim.individuals.domain.usecases.person.dependencies.SearchPersonService;

@Service
@RequiredArgsConstructor
public class PostgresSearchPersonService implements SearchPersonService {
  final PersonRepository personRepository;

  @Override
  public Page<Person> search(Pageable pageable, String query) {

    // Create base specification
    Specification<PersonModel> spec = Specification.where(null);

    // Add RSQL filter if present
    if (query != null && !query.isEmpty()) {
      var rootNode = new RSQLParser().parse(query);
      spec = rootNode.accept(new CustomRsqlVisitor<PersonModel>());
    }
    var sort = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var results = personRepository.findAll(spec, PageRequest.of(
            pageable.page(),
            pageable.size(),
            sort));

    return new Page<>(results.getNumber(), results.getSize(), results.getTotalPages(),
            results.toList().stream().map(
                    csm -> csm.getResource()).toList());
  }

}
