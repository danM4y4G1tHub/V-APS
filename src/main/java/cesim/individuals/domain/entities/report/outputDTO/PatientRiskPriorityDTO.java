package cesim.individuals.domain.entities.report.outputDTO;

import cesim.individuals.domain.entities.Patient;

public record PatientRiskPriorityDTO(
        Patient patient,
        int riskScore,
        String riskLevel
) {
}
