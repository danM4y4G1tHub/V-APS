package cesim.individuals.domain.usecases.vacinne.depenencies;

import cesim.individuals.domain.entities.ImmunizationRecommendation;
import cesim.individuals.domain.entities.vaccine.VaccineReportDTO;

import java.time.LocalDate;
import java.util.List;

public interface VaccineManagementService {
  VaccineReportDTO generateVaccineReport(LocalDate reportDate);

  List<ImmunizationRecommendation> getVaccineRecommendations();
}
