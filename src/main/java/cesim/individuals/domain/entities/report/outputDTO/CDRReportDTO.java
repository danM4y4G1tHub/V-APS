package cesim.individuals.domain.entities.report.outputDTO;

import java.util.Map;

public record CDRReportDTO(
        String crdCode,
        int totalResidence,
        int sickResidents,
        int cleanlinessScore,
        Map<String, Integer> diseaseCases,
        String mainHealthConcern
) {
}
