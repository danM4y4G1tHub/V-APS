//package cesim.individuals.infrastructure.services.report;
//
//import cesim.individuals.infrastructure.repository.*;
//import cesim.individuals.infrastructure.repository.models.*;
//import cesim.individuals.domain.entities.*;
//import cesim.individuals.domain.entities.report.outputDTO.MonthlyStatisticsReportDTO;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDate;
//import java.time.YearMonth;
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class PostgresStatisticsReportServiceTest {
//
//  @Mock
//  private PatientRepository patientRepository;
//
//  @Mock
//  private ConditionRepository conditionRepository;
//
//  @Mock
//  private EncounterRepository encounterRepository;
//
//  @Mock
//  private ObservationRepository observationRepository;
//
//  @InjectMocks
//  private PostgresStatisticsReportService reportService;
//
//  private PatientModel createPatient(String id, LocalDate birthDate, Patient.Gender gender) {
//    PatientModel patient = mock(PatientModel.class);
//    Patient patientResource = mock(Patient.class);
//
//    when(patient.getId()).thenReturn(id);
//    when(patient.getResource()).thenReturn(patientResource);
//    when(patientResource.birthDate()).thenReturn(birthDate);
//    when(patientResource.gender()).thenReturn(gender);
//
//    return patient;
//  }
//
//  private ConditionModel createCondition(String id, String patientId, String code) {
//    ConditionModel condition = mock(ConditionModel.class);
//    Condition conditionResource = mock(Condition.class);
//    Condition.Coding coding = mock(Condition.Coding.class);
//
//    when(condition.getId()).thenReturn(id);
//    when(condition.getResource()).thenReturn(conditionResource);
//    when(conditionResource.subject()).thenReturn(new Condition.Reference("Patient/" + patientId));
//    when(conditionResource.code()).thenReturn(new Condition.CodeableConcept(List.of(coding)));
//    when(coding.code()).thenReturn(code);
//
//    return condition;
//  }
//
//  // Prueba para grupos de edad con valores límite
//  @Test
//  void calculatePatientsByAgeGroup_shouldHandleBoundaryValues() {
//    LocalDate today = LocalDate.now();
//    List<PatientModel> patients = Arrays.asList(
//            createPatient("1", today.minusYears(0), Patient.Gender.MALE),
//            createPatient("2", today.minusYears(1), Patient.Gender.FEMALE),
//            createPatient("3", today.minusYears(2), Patient.Gender.OTHER),
//            createPatient("4", today.minusYears(5), Patient.Gender.UNKNOWN),
//            createPatient("5", today.minusYears(65), Patient.Gender.MALE),
//            createPatient("6", today.minusYears(66), Patient.Gender.FEMALE),
//            createPatient("7", null, Patient.Gender.MALE));
//
//    Map<String, Integer> result = reportService.calculatePatientsByAgeGroup(patients);
//
//    assertEquals(1, result.get("0-1"));    // 0 años
//    assertEquals(2, result.get("2-5"));     // 1 y 2 años (1 entra en 2-5 por implementación actual)
//    assertEquals(1, result.get("51-65"));   // 65 años
//    assertEquals(1, result.get("65+"));     // 66 años
//    assertEquals(6, result.values().stream().mapToInt(Integer::intValue).sum()); // 7 pacientes - 1 sin fecha
//  }
//
//  // Prueba para pacientes sin fecha de nacimiento
//  @Test
//  void calculatePatientsByAgeGroup_shouldHandleMissingBirthDates() {
//    List<PatientModel> patients = Arrays.asList(
//            createPatient("1", null, Patient.Gender.MALE),
//            createPatient("2", null, Patient.Gender.FEMALE)
//    );
//
//    Map<String, Integer> result = reportService.calculatePatientsByAgeGroup(patients);
//
//    assertTrue(result.isEmpty());
//  }
//
//  // Prueba para conteo de condiciones crónicas
//  @Test
//  void calculateChronicConditions_shouldCountCorrectly() {
//    // Preparar datos
//    List<PatientModel> patients = Arrays.asList(
//            createPatient("p1", LocalDate.now(), Patient.GenderEnum.MALE),
//            createPatient("p2", LocalDate.now(), Patient.GenderEnum.FEMALE)
//    );
//
//    List<ConditionModel> conditions = Arrays.asList(
//            createCondition("c1", "p1", "38341003"),   // Hipertensión
//            createCondition("c2", "p1", "44054006"),   // Diabetes
//            createCondition("c3", "p2", "44054006"),   // Diabetes
//            createCondition("c4", "p2", "99999999")    // Otra condición
//    );
//
//    when(conditionRepository.findByPatientIds(Arrays.asList("p1", "p2"))).thenReturn(conditions);
//
//    // Ejecutar
//    Map<String, Integer> result = reportService.calculateChronicConditions(patients);
//
//    // Verificar
//    assertEquals(1, result.get("HIPERTENCIÓN"));
//    assertEquals(2, result.get("DIABETES"));
//    assertEquals(0, result.get("ENFERMEDAD_CARDIACA"));
//  }
//
//  // Prueba para mujeres embarazadas
//  @Test
//  void calculatePregnantWomen_shouldDetectPregnancy() {
//    // Preparar datos
//    List<PatientModel> patients = Arrays.asList(
//            createPatient("p1", LocalDate.now(), Patient.GenderEnum.FEMALE),
//            createPatient("p2", LocalDate.now(), Patient.GenderEnum.FEMALE)
//    );
//
//    ObservationModel obs1 = mock(ObservationModel.class);
//    Observation obsResource1 = mock(Observation.class);
//    Observation.Coding coding1 = mock(Observation.Coding.class);
//
//    when(obs1.getResource()).thenReturn(obsResource1);
//    when(obsResource1.code()).thenReturn(new Observation.CodeableConcept(List.of(coding1)));
//    when(coding1.code()).thenReturn("77386006"); // Código de embarazo
//
//    when(observationRepository.findPregnancyObservations(
//            Arrays.asList("p1", "p2"),
//            "2023-10-01",
//            "2023-11-01")
//    ).thenReturn(List.of(obs1));
//
//    // Ejecutar
//    int result = reportService.calculatePregnantWomen(
//            patients,
//            LocalDate.of(2023, 10, 1),
//            LocalDate.of(2023, 10, 31)
//    );
//
//    // Verificar
//    assertEquals(1, result);
//  }
//
//  // Prueba para niños de 1 año (valor exacto)
//  @Test
//  void calculateOneYearOldChildren_shouldMatchExactDate() {
//    // Preparar datos
//    LocalDate reportStart = LocalDate.of(2023, 10, 1);
//    List<PatientModel> patients = Arrays.asList(
//            createPatient("p1", reportStart.minusYears(1), Patient.GenderEnum.MALE),         // Cumple exactamente
//            createPatient("p2", reportStart.minusYears(1).plusDays(1), Patient.GenderEnum.FEMALE),  // 1 día después
//            createPatient("p3", reportStart.minusYears(1).minusDays(1), Patient.GenderEnum.MALE)    // 1 día antes
//    );
//
//    // Ejecutar
//    int result = reportService.calculateOneYearOldChildren(patients, reportStart);
//
//    // Verificar
//    assertEquals(1, result);
//  }
//
//  // Prueba integral con datos completos
//  @Test
//  void generateMonthlyReport_shouldCalculateAllMetrics() {
//    // Configurar mes
//    YearMonth month = YearMonth.of(2023, 10);
//    LocalDate start = LocalDate.of(2023, 10, 1);
//    LocalDate end = LocalDate.of(2023, 10, 31);
//
//    // Configurar pacientes
//    List<PatientModel> patients = Arrays.asList(
//            createPatient("p1", LocalDate.now().minusYears(30), Patient.GenderEnum.MALE),
//            createPatient("p2", LocalDate.now().minusYears(5), Patient.GenderEnum.FEMALE)
//    );
//
//    when(patientRepository.findAll()).thenReturn(patients);
//
//    // Configurar condiciones
//    when(conditionRepository.findByRecordedDate(start.toString(), end.plusDays(1).toString()))
//            .thenReturn(List.of(
//                    createCondition("c1", "p1", "44054006")
//            ));
//
//    // Configurar encuentros
//    EncounterModel encounter = mock(EncounterModel.class);
//    Encounter encResource = mock(Encounter.class);
//    Encounter.Reason reason = mock(Encounter.Reason.class);
//    Encounter.Reason.Use use = mock(Encounter.Reason.Use.class);
//
//    when(encounter.getResource()).thenReturn(encResource);
//    when(encResource.reason()).thenReturn(List.of(reason));
//    when(reason.use()).thenReturn(List.of(use));
//    when(use.text()).thenReturn("Dolor de cabeza");
//
//    when(encounterRepository.findByDateBetween(start.toString(), end.plusDays(1).toString()))
//            .thenReturn(List.of(encounter));
//
//    // Configurar observaciones de embarazo
//    when(observationRepository.findPregnancyObservations(
//            anyList(),
//            eq(start.toString()),
//            eq(end.plusDays(1).toString()))
//    ).thenReturn(Collections.emptyList());
//
//    // Ejecutar
//    MonthlyStatisticsReportDTO report = reportService.generateMonthlyReport(month);
//
//    // Verificar resultados
//    assertEquals(1, report.patientsBAgeGroup().get("19-30"));
//    assertEquals(1, report.patientsBAgeGroup().get("2-5"));
//
//    assertEquals(1, report.patientsByGender().get("MALE"));
//    assertEquals(1, report.patientsByGender().get("FEMALE"));
//
//    assertEquals(1, report.newDiseasedCases());
//    assertEquals(0, report.pregnantWomen());
//    assertEquals(0, report.oneYearOldChildren());
//
//    assertEquals(1, report.consultationsByPathology().get("Dolor de cabeza"));
//  }
//
//  // Prueba para repositorios vacíos
//  @Test
//  void generateMonthlyReport_shouldHandleEmptyRepositories() {
//    // Configurar mes
//    YearMonth month = YearMonth.of(2023, 10);
//
//    // Configurar repositorios vacíos
//    when(patientRepository.findAll()).thenReturn(Collections.emptyList());
//    when(conditionRepository.findByRecordedDate(any(), any())).thenReturn(Collections.emptyList());
//    when(encounterRepository.findByDateBetween(any(), any())).thenReturn(Collections.emptyList());
//    when(observationRepository.findPregnancyObservations(anyList(), any(), any())).thenReturn(Collections.emptyList());
//
//    // Ejecutar
//    MonthlyStatisticsReportDTO report = reportService.generateMonthlyReport(month);
//
//    // Verificar resultados vacíos
//    assertTrue(report.patientsBAgeGroup().isEmpty());
//    assertTrue(report.patientsByGender().isEmpty());
//    assertEquals(0, report.newDiseasedCases());
//    assertEquals(0, report.pregnantWomen());
//    assertEquals(0, report.oneYearOldChildren());
//    assertTrue(report.consultationsByPathology().isEmpty());
//  }
//
//  // Prueba para género nulo
//  @Test
//  void calculatePatientsByGender_shouldHandleNullGender() {
//    // Preparar datos
//    PatientModel patient = mock(PatientModel.class);
//    Patient patientResource = mock(Patient.class);
//
//    when(patient.getResource()).thenReturn(patientResource);
//    when(patientResource.gender()).thenReturn(null);
//
//    // Ejecutar
//    Map<String, Integer> result = reportService.calculatePatientsByGender(List.of(patient));
//
//    // Verificar
//    assertEquals(1, result.get("null"));
//  }
//}
