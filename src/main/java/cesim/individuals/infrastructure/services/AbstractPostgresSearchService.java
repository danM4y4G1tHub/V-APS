package cesim.individuals.infrastructure.services;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.PageRequest;

import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;

public abstract class AbstractPostgresSearchService<T, M, R extends PagingAndSortingRepository<M, ?> & JpaSpecificationExecutor<M>> {

    protected final R repository;

    protected AbstractPostgresSearchService(R repository) {
        this.repository = repository;
    }

    public Page<T> search(Pageable pageable, String query) {
        // Create base specification
        Specification<M> spec = Specification.where(null);

        // Add RSQL filter if present
        if (query != null && !query.isEmpty()) {
            var rootNode = new RSQLParser().parse(query);
            spec = rootNode.accept(new CustomRsqlVisitor<M>());
        }

        var sort = Sort.by(
                pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
                pageable.sortBy());

        var results = repository.findAll(spec, PageRequest.of(
                pageable.page(),
                pageable.size(),
                sort));

        return new Page<>(
            results.getNumber(),
            results.getSize(),
            results.getTotalPages(),
            results.getContent().stream()
                   .map(this::mapToEntity)
                   .toList()
        );
    }

    // Abstract method to be implemented by concrete classes
    protected abstract T mapToEntity(M model);
}
