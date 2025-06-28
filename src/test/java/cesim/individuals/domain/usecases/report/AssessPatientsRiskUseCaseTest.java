package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.HumanName;
import cesim.individuals.domain.entities.Identifier;
import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.report.outputDTO.PatientRiskPriorityDTO;
import cesim.individuals.domain.usecases.report.dependencies.PatientRiskAssessmentService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
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
class AssessPatientsRiskUseCaseTest {
  @Mock
  private PatientRiskAssessmentService assessmentService;

  @InjectMocks
  private AssessPatientsRiskUseCase assessPatientsRiskUseCase;

  @Test
  void execute_shouldReturnRiskPrioritiesForPatients() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");

    Patient patient = new Patient(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            List.of(new Identifier(Identifier.Use.OFFICIAL, null, null, "92020254321",
                    null, null)), true,
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Rodríguez",
                    List.of("María", "Elena"), null, null, null)),
            null, Patient.Gender.FEMALE, LocalDate.of(1992, 2, 2),
            null, null, null, null
    );

    PatientRiskPriorityDTO riskDTO = new PatientRiskPriorityDTO(patient, 85, "ALTO");

    Page<PatientRiskPriorityDTO> expectedPage = new Page<>(
            0, 10, 1, List.of(riskDTO)
    );

    when(assessmentService.assessPatientsRisk(eq(pageable)))
            .thenReturn(expectedPage);

    CompletableFuture<AssessPatientsRiskUseCase.Output> future = assessPatientsRiskUseCase.execute(
            new AssessPatientsRiskUseCase.Input(pageable)
    );

    AssessPatientsRiskUseCase.Output output = future.get();

    assertNotNull(output);
    assertEquals(1, output.riskPriorities().items().size());

    PatientRiskPriorityDTO result = output.riskPriorities().items().get(0);
    assertEquals("92020254321", result.patient().identifier().get(0).value());

    StringBuilder fullName = new StringBuilder();
    fullName.append(result.patient().name().get(0).given().get(0))
            .append(" ").append(result.patient().name().get(0).given().get(1))
            .append(" ").append(result.patient().name().get(0).family());

    assertEquals("María Elena Rodríguez", fullName.toString());
    assertEquals(85, result.riskScore());
    assertEquals("ALTO", result.riskLevel());

    verify(assessmentService).assessPatientsRisk(pageable);
  }

  @Test
  void shouldHandleMultipleRiskLevels() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");

    Patient highRiskPatient = new Patient(
            UUID.randomUUID().toString(),
            List.of(new Identifier(Identifier.Use.OFFICIAL, null,
                    null, "111", null, null)
            ), true,
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, null,
                    List.of("Apellido"), null, null, null)),
            null, Patient.Gender.MALE, LocalDate.now(), null,
            null, null, null
    );

    Patient mediumRiskPatient = new Patient(
            UUID.randomUUID().toString(),
            List.of(new Identifier(Identifier.Use.OFFICIAL, null,
                    null, "222", null, null)
            ), true,
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, null,
                    List.of("Apellido"), null, null, null)),
            null, Patient.Gender.FEMALE, LocalDate.now(), null,
            null, null, null
    );

    Patient lowRiskPatient = new Patient(
            UUID.randomUUID().toString(),
            List.of(new Identifier(Identifier.Use.OFFICIAL, null,
                    null, "333", null, null)
            ), true,
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, null,
                    List.of("Apellido"), null, null, null)),
            null, Patient.Gender.MALE, LocalDate.now(), null,
            null, null, null
    );

    List<PatientRiskPriorityDTO> risks = List.of(
            new PatientRiskPriorityDTO(highRiskPatient, 90, "MUY ALTO"),
            new PatientRiskPriorityDTO(mediumRiskPatient, 60, "MODERADO"),
            new PatientRiskPriorityDTO(lowRiskPatient, 30, "BAJO")
    );

    Page<PatientRiskPriorityDTO> expectedPage = new Page<>(0, 10, 3, risks);

    when(assessmentService.assessPatientsRisk(any()))
            .thenReturn(expectedPage);

    AssessPatientsRiskUseCase.Output output = assessPatientsRiskUseCase.execute(
            new AssessPatientsRiskUseCase.Input(pageable)
    ).get();

    assertEquals(3, output.riskPriorities().items().size());
    assertEquals("MUY ALTO", output.riskPriorities().items().get(0).riskLevel());
    assertEquals("MODERADO", output.riskPriorities().items().get(1).riskLevel());
    assertEquals("BAJO", output.riskPriorities().items().get(2).riskLevel());
  }

  @Test
  void shouldHandleEmptyResults() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    Page<PatientRiskPriorityDTO> emptyPage = new Page<>(0, 0, 0, List.of());

    when(assessmentService.assessPatientsRisk(any()))
            .thenReturn(emptyPage);

    AssessPatientsRiskUseCase.Output output = assessPatientsRiskUseCase.execute(
            new AssessPatientsRiskUseCase.Input(pageable)
    ).get();

    assertTrue(output.riskPriorities().items().isEmpty());
    assertEquals(0, output.riskPriorities().pageSize());
  }

  @Test
  void shouldHandlePaginationCorrectly() throws ExecutionException, InterruptedException {
    Pageable firstPage = new Pageable(0, 2, "id", "asc");
    List<PatientRiskPriorityDTO> firstPageContent = createRiskDTOs(2);
    Page<PatientRiskPriorityDTO> firstPageResult = new Page<>(0, 2, 5, firstPageContent);

    Pageable secondPage = new Pageable(1, 2, "id", "asc");
    List<PatientRiskPriorityDTO> secondPageContent = createRiskDTOs(2);
    Page<PatientRiskPriorityDTO> secondPageResult = new Page<>(1, 2, 5, secondPageContent);

    when(assessmentService.assessPatientsRisk(eq(firstPage)))
            .thenReturn(firstPageResult);

    when(assessmentService.assessPatientsRisk(eq(secondPage)))
            .thenReturn(secondPageResult);

    AssessPatientsRiskUseCase.Output output1 = assessPatientsRiskUseCase.execute(
            new AssessPatientsRiskUseCase.Input(firstPage)
    ).get();

    assertEquals(2, output1.riskPriorities().items().size());
    assertEquals(0, output1.riskPriorities().pageNumber());

    AssessPatientsRiskUseCase.Output output2 = assessPatientsRiskUseCase.execute(
            new AssessPatientsRiskUseCase.Input(secondPage)
    ).get();

    assertEquals(2, output2.riskPriorities().items().size());
    assertEquals(1, output2.riskPriorities().pageNumber());
    assertEquals(5, output2.riskPriorities().totalPages());
  }

  private List<PatientRiskPriorityDTO> createRiskDTOs(int count) {
    return java.util.stream.IntStream.range(0, count)
            .mapToObj(i -> new PatientRiskPriorityDTO(
                    new Patient(
                    UUID.randomUUID().toString(),
                    List.of(new Identifier(Identifier.Use.OFFICIAL, null,
                            null, "ID-" + i, null, null)
                    ), true,
                    List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Apellido",
                            List.of("Paciente " + i), null, null, null)),
                    null, Patient.Gender.MALE, LocalDate.now(), null,
                    null, null, null
            ),
                    50 + i,
                    "NIVEL " + i
            ))
            .collect(java.util.stream.Collectors.toList());
  }

  @Test
  void inputRecord_shouldStorePageable() {
    Pageable pageable = new Pageable(1, 20, "id", "asc");
    AssessPatientsRiskUseCase.Input input = new AssessPatientsRiskUseCase.Input(pageable);
    assertEquals(pageable, input.pageable());
    assertEquals(1, input.pageable().page());
    assertEquals(20, input.pageable().size());
  }

  @Test
  void outputRecord_shouldStoreRiskPriorities() {
    Page<PatientRiskPriorityDTO> riskPage = new Page<>(0, 10, 0, List.of());
    AssessPatientsRiskUseCase.Output output = new AssessPatientsRiskUseCase.Output(riskPage);
    assertEquals(riskPage, output.riskPriorities());
    assertTrue(output.riskPriorities().items().isEmpty());
  }

  @Test
  void shouldHandleServiceExceptions() {
    when(assessmentService.assessPatientsRisk(any()))
            .thenThrow(new RuntimeException("Error en servicio"));

    CompletableFuture<AssessPatientsRiskUseCase.Output> future = assessPatientsRiskUseCase.execute(
            new AssessPatientsRiskUseCase.Input(new Pageable(0, 10, "id", "asc"))
    );

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertInstanceOf(RuntimeException.class, exception.getCause());
    assertEquals("Error en servicio", exception.getCause().getMessage());
  }

  private Patient createPatientWithRisk(int riskScore) {
    return new Patient(
            UUID.randomUUID().toString(),
            List.of(new Identifier(Identifier.Use.OFFICIAL, null,
                    null, "ID-" + riskScore, null, null)
            ), true,
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Paciente" + riskScore,
                    List.of("Paciente"), null, null, null)),
            null, Patient.Gender.MALE, LocalDate.now(), null,
            null, null, null
    );
  }

  @ParameterizedTest
  @CsvSource({
          "95, MUY ALTO",
          "85, ALTO",
          "70, MODERADO ALTO",
          "60, MODERADO",
          "40, BAJO",
          "20, MUY BAJO"
  })
  void shouldClassifyRiskCorrectly(int score, String expectedLevel) throws ExecutionException, InterruptedException {
    Patient patient = createPatientWithRisk(score);
    Page<PatientRiskPriorityDTO> page = new Page<>(0, 10, 1, List.of(
            new PatientRiskPriorityDTO(patient, score, expectedLevel)
    ));

    when(assessmentService.assessPatientsRisk(any())).thenReturn(page);

    AssessPatientsRiskUseCase.Output output = assessPatientsRiskUseCase.execute(
            new AssessPatientsRiskUseCase.Input(new Pageable(0, 10, "id", "asc"))).get();

    assertEquals(expectedLevel, output.riskPriorities().items().get(0).riskLevel());
  }
}
