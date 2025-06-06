package cesim.individuals.domain.entities;

import java.math.BigDecimal;

public record SampledData(
        Quantity origin,
        BigDecimal period,
        BigDecimal factor,
        BigDecimal lowerLimit,
        BigDecimal upperLimit,
        Integer dimensions,
        String data
) {
}
