package cesim.individuals.domain.utils;

public record Pageable(int page, int size, String sortBy, String sortDirection) {
}
