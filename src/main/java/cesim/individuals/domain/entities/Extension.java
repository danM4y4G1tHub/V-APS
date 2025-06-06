package cesim.individuals.domain.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record Extension(
        String id,
        String url,
        Boolean valueBoolean,
        Integer valueInteger,
        BigDecimal valueDecimal,
        String valueString,
        String valueUri,
        String valueUrl,
        String valueCanonical,
        String valueUuid,
        Instant valueInstant,
        String valueDate,
        String valueDateTime,
        String valueTime,
        String valueCode,
        String valueOid,
        String valueId,
        String valueMarkdown,
        String valueBase64Binary,
        Coding valueCoding,
        CodeableConcept valueCodeableConcept,
        Quantity valueQuantity,
        Duration valueDuration,
        Ratio valueRatio,
        SampledData valueSampledData,
        Period valuePeriod,
        Range valueRange,
        HumanName valueHumanName,
        Address valueAddress,
        ContactPoint valueContactPoint,
        Timing valueTiming,
        Reference valueReference,
        List<Extension> extension
) {
}
