package cesim.individuals.domain.entities.report.specInput;

import java.time.LocalDate;

public record ClinicalReportFilterSpec(
        // Diagnóstico/Patología
        String pathologyCode,
        // Paciente/Demografía
        String patientIdentifier,            // Otro identificador (DNI, cédula, etc.)
        String patientName,                  // Nombre completo o parcial
        String patientGender,                // "male", "female", "other", "unknown"
        // Fechas
        LocalDate startDate,                 // Fecha inicial (diagnóstico, evento, etc.)
        LocalDate endDate                   // Fecha final
) {
}
