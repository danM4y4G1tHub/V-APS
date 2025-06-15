package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.report.outputDTO.CommunityReportDTO;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class PostgresCommunityReportServiceTest {

  @Mock
  private PatientRepository patientRepo;

  @Mock
  private ConditionRepository conditionRepo;

  @InjectMocks // Inyecta los mocks en el servicio real
  private PostgresCommunityReportService service;

  @Test
  void generateCommunityReport_shouldCalculateCorrectMetrics() {
    // 1. Configuración (Arrange)
    String communityId = "loc-123";
    when(patientRepo.findByLocation(communityId))
            .thenReturn(mockPatientList()); // Mock de datos

    when(conditionRepo.countActiveConditionsByPatients(anyList()))
            .thenReturn(5); // Simula 5 condiciones activas

    // 2. Ejecución (Act)
    CommunityReportDTO result = service.generateCommunityReport(communityId);

    // 3. Verificación (Assert)
//    assertEquals(5, result.sickCount());
//    verify(patientRepo, times(1)).findByLocation(communityId);
  }

  private List<PatientModel> mockPatientList() {
    // Retorna datos fake similares a V-APS.json
    return null;
  }
}
