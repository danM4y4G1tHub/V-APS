package cesim.individuals.domain.utils;

import java.util.List;

public record Page<T>(
    int pageNumber,
    int pageSize,
    int totalPages,
    boolean hasNext,
    boolean hasPrevious,
    List<T> items
) {
    public Page(int pageNumber, int pageSize, int totalPages, List<T> items) {
        this(
            pageNumber,
            pageSize,
            totalPages,
            totalPages > pageNumber + 1,
            pageNumber > 0,
            items
        );
    }
}
