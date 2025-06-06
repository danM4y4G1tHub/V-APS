package cesim.individuals.domain.entities;

import java.util.List;

public record Dosage(
        Integer sequence,
        String text,
        List<CodeableConcept> additionalInstruction,
        Timing timing,
        Boolean asNeededBoolean,
        CodeableConcept asNeededCodeableConcept,
        CodeableConcept site,
        CodeableConcept route,
        CodeableConcept method,
        Range doseRange,
        Quantity doseQuantity,
        Ratio rateRatio,
        Range rateRange,
        Quantity rateQuantity,
        Ratio maxDosePerPeriod,
        Quantity maxDosePerAdministration,
        Quantity maxDosePerLifetime
) {}
