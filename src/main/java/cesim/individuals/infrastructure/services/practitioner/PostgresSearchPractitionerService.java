package cesim.individuals.infrastructure.services.practitioner;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cesim.individuals.domain.entities.Practitioner;
import cesim.individuals.domain.usecases.practitioner.dependencies.SearchPractitionerService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.PractitionerRepository;
import cesim.individuals.infrastructure.repository.models.PractitionerModel;
import cesim.individuals.infrastructure.repository.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Service
@RequiredArgsConstructor
public class PostgresSearchPractitionerService implements SearchPractitionerService {
    private final PractitionerRepository practitionerRepository;

    @Override
    public Page<Practitioner> search(Pageable pageable, String query) {
        Specification<PractitionerModel> spec = Specification.where(null);

        if (query != null && !query.isEmpty()) {
            var rootNode = new RSQLParser().parse(query);
            spec = rootNode.accept(new CustomRsqlVisitor<>());
        }

        var sort = Sort.by(
                pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
                pageable.sortBy());

        var results = practitionerRepository.findAll(spec, PageRequest.of(
                pageable.page(),
                pageable.size(),
                sort));

        return new Page<>(
                results.getNumber(),
                results.getSize(),
                results.getTotalPages(),
                results.toList().stream().map(PractitionerModel::getResource).toList());
    }
}