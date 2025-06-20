package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.*;
import cesim.individuals.domain.entities.report.outputDTO.ClinicalReportDTO;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.usecases.report.dependencies.ClinicalReportFilterService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClinicalReportFilterUseCaseTest {

  @Mock
  private ClinicalReportFilterService filterService;

  @InjectMocks
  private ClinicalReportFilterUseCase clinicalReportFilterUseCase;

  @Test
  void execute_shouldReturnClinicalReportWithPatientsAndConditions() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");

    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
            "44054006",
            "92020254321",
            "María Elena",
            "female",
            LocalDate.of(1990, 1, 1),
            LocalDate.of(2023, 12, 31)
    );

    ClinicalReportDTO.PatientInfo patientInfo = new ClinicalReportDTO.PatientInfo(
            List.of(new Identifier(null, null, "http://minsap.cu/ci", "92020254321",
                    null, null)),
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Rodríguez", List.of("María", "Elena"),
                    null, null, null)
            ),
            Patient.Gender.FEMALE,
            LocalDate.of(1992, 2, 2),
            List.of(new ContactPoint(ContactPoint.System.PHONE, "+5355512345", ContactPoint.Use.WORK,
                    null, null)),
            List.of(new Address(Address.Type.BOTH, Address.Use.HOME, List.of("Calle 23 #456"), null,
                    "La Habana", "La Habana", "10400", "Cuba", null, null, null)),
            new CodeableConcept(List.of(new Coding("http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", null,
                    "M", "Casada", null)), null)
    );

    Page<ClinicalReportDTO.PatientInfo> patientPage = new Page<>(0, 10, 1, List.of(patientInfo));

    ClinicalReportDTO.ConditionsInfo conditionInfo = new ClinicalReportDTO.ConditionsInfo(
            new CodeableConcept(List.of(
                    new Coding("http://terminology.hl7.org/CodeSystem/condition-clinical",
                            null, "active", "Active", null)), null),
            new CodeableConcept(List.of(
                    new Coding("http://snomed.info/sct", "44054006", null,
                            "Diabetes mellitus tipo 2", null)), null),
            LocalDateTime.parse("2023-05-15T14:30:00"),
            null,
            new Reference("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", null, null, null)
    );

    Page<ClinicalReportDTO.ConditionsInfo> conditionPage = new Page<>(0, 1, 10, List.of(conditionInfo));

    ClinicalReportDTO expectedReport = new ClinicalReportDTO(patientPage, conditionPage);

    when(filterService.filterConditions(eq(pageable), eq(filterSpec)))
            .thenReturn(expectedReport);

    CompletableFuture<ClinicalReportFilterUseCase.Output> future = clinicalReportFilterUseCase.execute(
            new ClinicalReportFilterUseCase.Input(pageable, filterSpec)
    );

    ClinicalReportFilterUseCase.Output output = future.get();
    ClinicalReportDTO result = output.clinicalReportDTO();

    assertNotNull(result);
    assertEquals(1, result.patients().items().size());
    assertEquals(1, result.conditions().items().size());

    ClinicalReportDTO.PatientInfo resultPatient = result.patients().items().get(0);
    assertEquals("92020254321", resultPatient.identifier().get(0).value());
    assertEquals("Rodríguez", resultPatient.name().get(0).family());
    assertEquals("María", resultPatient.name().get(0).given().get(0));
    assertEquals("Elena", resultPatient.name().get(0).given().get(1));
    assertEquals(Patient.Gender.FEMALE, resultPatient.gender());
    assertEquals(LocalDate.of(1992, 2, 2), resultPatient.birthDate());
    assertEquals("+5355512345", resultPatient.telecom().get(0).value());
    assertEquals("Calle 23 #456", resultPatient.address().get(0).line().get(0));

    // Verificar datos de la condición
    ClinicalReportDTO.ConditionsInfo resultCondition = result.conditions().items().get(0);
    assertEquals("Diabetes mellitus tipo 2", resultCondition.code().coding().get(0).display());
    assertEquals("active", resultCondition.clinicalStatus().coding().get(0).code());
    assertEquals(LocalDateTime.parse("2023-05-15T14:30:00"), resultCondition.recordedDate());
    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", resultCondition.subject().reference());

    // Verificar que el filtro se aplicó correctamente
    verify(filterService).filterConditions(pageable, filterSpec);
  }

  @Test
  void shouldHandleEmptyResults() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");

    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
            "44054006",
            "92020254321",
            "María Elena",
            "female",
            LocalDate.of(1990, 1, 1),
            LocalDate.of(2023, 12, 31)
    );

    Page<ClinicalReportDTO.PatientInfo> emptyPatientPage = new Page<>(0, 10, 0, List.of());
    Page<ClinicalReportDTO.ConditionsInfo> emptyConditionPage = new Page<>(0, 10, 0, List.of());
    ClinicalReportDTO expectedReport = new ClinicalReportDTO(emptyPatientPage, emptyConditionPage);

    when(filterService.filterConditions(any(), any())).thenReturn(expectedReport);

    CompletableFuture<ClinicalReportFilterUseCase.Output> future = clinicalReportFilterUseCase.execute(
            new ClinicalReportFilterUseCase.Input(pageable, filterSpec)
    );

    ClinicalReportFilterUseCase.Output output = future.get();
    ClinicalReportDTO result = output.clinicalReportDTO();

    assertTrue(result.patients().items().isEmpty());
    assertTrue(result.conditions().items().isEmpty());
  }

  @Test
  void shouldHandleMultiplePatientsAndConditions() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");

    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
            "44054006",
            "92020254321",
            "María Elena",
            "female",
            LocalDate.of(1990, 1, 1),
            LocalDate.of(2023, 12, 31)
    );

    ClinicalReportDTO.PatientInfo patient1 = createPatient("92020254321", "María Elena", "Rodríguez");
    ClinicalReportDTO.PatientInfo patient2 = createPatient("91010112345", "Carlos Manuel", "González");

    ClinicalReportDTO.ConditionsInfo condition1 = createCondition("44054006", "Diabetes mellitus tipo 2");
    ClinicalReportDTO.ConditionsInfo condition2 = createCondition("73211009", "Diabetes mellitus tipo 1");
    ClinicalReportDTO.ConditionsInfo condition3 = createCondition("38341003", "Hipertensión arterial");

    Page<ClinicalReportDTO.PatientInfo> patientPage = new Page<>(0, 10, 2,
            List.of(patient1, patient2)
    );
    Page<ClinicalReportDTO.ConditionsInfo> conditionPage = new Page<>(0, 10, 3,
            List.of(condition1, condition2, condition3)
    );

    ClinicalReportDTO expectedReport = new ClinicalReportDTO(patientPage, conditionPage);

    when(filterService.filterConditions(any(), any())).thenReturn(expectedReport);

    ClinicalReportFilterUseCase.Output output = clinicalReportFilterUseCase.execute(
            new ClinicalReportFilterUseCase.Input(pageable, filterSpec)
    ).get();

    assertEquals(2, output.clinicalReportDTO().patients().items().size());
    assertEquals(3, output.clinicalReportDTO().conditions().items().size());
  }

  @Test
  void inputRecord_shouldStorePageableAndFilterSpec() {
    Pageable pageable = new Pageable(1, 20, "id", "asc");

    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
            "44054006",
            "92020254321",
            "María Elena",
            "female",
            LocalDate.of(1990, 1, 1),
            LocalDate.of(2023, 12, 31)
    );
    ClinicalReportFilterUseCase.Input input = new ClinicalReportFilterUseCase.Input(pageable, filterSpec);

    assertEquals(pageable, input.pageable());
    assertEquals(filterSpec, input.filterSpec());
    assertEquals(1, input.pageable().page());
    assertEquals(20, input.pageable().size());
  }

  @Test
  void outputRecord_shouldStoreClinicalReportDTO() {
    Page<ClinicalReportDTO.PatientInfo> patientPage = new Page<>(0, 10, 0, List.of());
    Page<ClinicalReportDTO.ConditionsInfo> conditionPage = new Page<>(0, 10, 0, List.of());
    ClinicalReportDTO reportDTO = new ClinicalReportDTO(patientPage, conditionPage);

    ClinicalReportFilterUseCase.Output output = new ClinicalReportFilterUseCase.Output(reportDTO);

    assertEquals(reportDTO, output.clinicalReportDTO());
    assertTrue(output.clinicalReportDTO().patients().items().isEmpty());
  }

  private ClinicalReportDTO.PatientInfo createPatient(String id, String firstName, String lastName) {
    return new ClinicalReportDTO.PatientInfo(
            List.of(new Identifier(null, null, "http://minsap.cu/ci", id, null, null)),
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, lastName, List.of(firstName.split(" ")),
                    null, null, null)
            ),
            Patient.Gender.FEMALE,
            LocalDate.now().minusYears(30),
            List.of(new ContactPoint(ContactPoint.System.PHONE, "+5355512345", ContactPoint.Use.WORK,
                    null, null)
            ),
            List.of(new Address(Address.Type.BOTH, Address.Use.HOME, List.of("Calle Principal"), null,
                    "Ciudad", "Cuba", "Provincia", "00000", null, null, null)),
            new CodeableConcept(List.of(new Coding("http://terminology.hl7.org/CodeSystem/v3-MaritalStatus",
                    null, "S", "Soltero", null)), null)
    );
  }

  private ClinicalReportDTO.ConditionsInfo createCondition(String code, String display) {
    return new ClinicalReportDTO.ConditionsInfo(
            new CodeableConcept(List.of(
                    new Coding("http://terminology.hl7.org/CodeSystem/condition-clinical", null,
                            "active", "Active", null)), null),
            new CodeableConcept(List.of(
                    new Coding("http://snomed.info/sct", null, code, display, null)),null),
            LocalDateTime.now().minusDays(30),
            null,
            new Reference("Patient/" + UUID.randomUUID(), null, null, null)
    );
  }

  private List<ClinicalReportDTO.PatientInfo> createPatients(int count) {
    return java.util.stream.IntStream.range(0, count)
            .mapToObj(i -> createPatient("ID-" + i, "Paciente " + i, "Apellido"))
            .collect(java.util.stream.Collectors.toList());
  }

  private List<ClinicalReportDTO.ConditionsInfo> createConditions(int count) {
    return java.util.stream.IntStream.range(0, count)
            .mapToObj(i -> createCondition("CODE-" + i, "Condición " + i))
            .collect(java.util.stream.Collectors.toList());
  }

@Test
void shouldHandleServiceExceptions() {
  when(filterService.filterConditions(any(), any()))
          .thenThrow(new RuntimeException("Error de base de datos"));

  CompletableFuture<ClinicalReportFilterUseCase.Output> future = clinicalReportFilterUseCase.execute(
          new ClinicalReportFilterUseCase.Input(
                  new Pageable(0, 10, "id", "asc"),
                  new ClinicalReportFilterSpec(
                          "44054006",
                          "92020254321",
                          "María Elena",
                          "female",
                          LocalDate.of(1990, 1, 1),
                          LocalDate.of(2023, 12, 31)
                  )
          )
  );

  ExecutionException exception = assertThrows(ExecutionException.class, future::get);
  assertTrue(exception.getCause() instanceof RuntimeException);
  assertEquals("Error de base de datos", exception.getCause().getMessage());
}
}
