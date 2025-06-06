package cesim.individuals.domain.usecases.vacinne.depenencies;

import cesim.individuals.domain.entities.Immunization;
import cesim.individuals.domain.entities.vaccine.VaccineReportDTO;
import cesim.individuals.domain.entities.vaccine.VaccineScheduleDTO;

import java.time.LocalDate;
import java.util.List;

public interface VaccineManagementService {
  VaccineReportDTO generateVaccineReport(LocalDate reportDate);

  void recordImmunization(Immunization immunization);

  List<VaccineScheduleDTO> getVaccineSchedules();
}
