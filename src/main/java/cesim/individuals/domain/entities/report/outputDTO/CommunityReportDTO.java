package cesim.individuals.domain.entities.report.outputDTO;

import java.util.Map;

public record CommunityReportDTO(
        String communityName,
        int totalPopulation,
        int sickCount,
        int cleanlinessScore,
        Map<String, Integer> diseaseIncidence,
        DemographicData demographicData
) {
  public record DemographicData(
          int childrenCount,
          int adultCount,
          int elderlyCount,
          int maleCount,
          int femaleCount
  ){}
}
