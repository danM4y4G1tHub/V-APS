package cesim.individuals.domain.entities.report.outputDTO;

public record MedicalStaffCountDTO(
        String clinicName,
        long doctorCount
) {}
