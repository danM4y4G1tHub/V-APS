package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.MedicalStaffCountDTO;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

public interface MedicalStaffFilterService {
  Page<MedicalStaffCountDTO> countDoctorsByClinic(Pageable pageable);
}
