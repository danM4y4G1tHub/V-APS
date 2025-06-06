package cesim.individuals.domain.usecases.report.dependencies;

import cesim.individuals.domain.entities.report.outputDTO.CriticalPatientDataDTO;

public interface GetCriticalPatientDataService {
  CriticalPatientDataDTO getCriticalDataByIdentification(String CI) throws Exception;
}
