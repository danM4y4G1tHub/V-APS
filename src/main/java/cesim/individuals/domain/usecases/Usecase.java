package cesim.individuals.domain.usecases;

import java.util.concurrent.CompletableFuture;

public interface Usecase<T, K> {
    CompletableFuture<K> execute(T request);
}
