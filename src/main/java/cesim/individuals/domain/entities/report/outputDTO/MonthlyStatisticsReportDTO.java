package cesim.individuals.domain.entities.report.outputDTO;

import java.util.Map;

public record MonthlyStatisticsReportDTO(
        Map<String, Integer> patientsBAgeGroup,
        Map<String, Integer> patientsByGender,
        Map<String, Integer> chronicConditions,
        int newDiseasedCases,
        int pregnantWomen,
        int oneYearOldChildren,
        Map<String, Integer> consultationsByPathology
) {
}
