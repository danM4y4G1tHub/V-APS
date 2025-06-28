package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.CodeableConcept;
import cesim.individuals.domain.entities.Coding;
import cesim.individuals.domain.entities.Dosage;
import cesim.individuals.domain.entities.HumanName;
import cesim.individuals.domain.entities.report.outputDTO.DerivationReportDTO;
import cesim.individuals.domain.usecases.report.dependencies.GenerateDerivationReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenerateDerivationReportUsecaseTest {

  @Mock
  private GenerateDerivationReportService reportService;

  @InjectMocks
  private GenerateDerivationReportUsecase generateDerivationReportUsecase;

  @Test
  void execute_shouldReturnDerivationReport() throws ExecutionException, InterruptedException {
    String patientId = "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a";

    DerivationReportDTO.PatientInfo patientInfo = new DerivationReportDTO.PatientInfo(
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Rodríguez", List.of("María", "Elena"),
                    null, null, null))
    );

    DerivationReportDTO.ConditionInfo conditionInfo = new DerivationReportDTO.ConditionInfo(
            new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null,
                            "44054006", "Diabetes mellitus tipo 2", null)),
                    null));

    DerivationReportDTO.MedicationInfo medicationInfo = new DerivationReportDTO.MedicationInfo(
            List.of(new Dosage(null,
                    "Aplicar 10 unidades subcutáneas antes del desayuno diariamente", null,
                    null, null, null, null, null, null,
                    null, null, null, null, null, null,
                    null, null))
    );

    DerivationReportDTO.AllergyInfo allergyInfo = new DerivationReportDTO.AllergyInfo(
            new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null,
                    "91930004", "Penicilina", null)), null)
    );

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            patientInfo,
            List.of(conditionInfo),
            List.of(medicationInfo),
            List.of(allergyInfo)
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    CompletableFuture<GenerateDerivationReportUsecase.Output> future = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    );

    GenerateDerivationReportUsecase.Output output = future.get();
    DerivationReportDTO result = output.derivationReport();

    assertNotNull(result);
    assertEquals("María Elena Rodríguez",
            result.patient().name().get(0).given().get(0) + " " +
                    result.patient().name().get(0).given().get(1) + " " +
                    result.patient().name().get(0).family());

    assertEquals(1, result.diagnostic().size());
    assertEquals("Diabetes mellitus tipo 2", result.diagnostic().get(0).code().coding().get(0).display());

    assertEquals(1, result.medications().size());
    assertEquals("Aplicar 10 unidades subcutáneas antes del desayuno diariamente",
            result.medications().get(0).dosageInstruction().get(0).text());

    assertEquals(1, result.allergies().size());
    assertEquals("Penicilina", result.allergies().get(0).code().coding().get(0).display());
  }

  @ParameterizedTest
  @MethodSource("provideReportVariations")
  void shouldHandleReportVariations(int diagnosticCount, int medicationCount,
          int allergyCount, boolean hasPatientName) throws ExecutionException, InterruptedException {
    String patientId = "test-patient";

    DerivationReportDTO.PatientInfo patientInfo = hasPatientName ?
            new DerivationReportDTO.PatientInfo(
                    List.of(new HumanName(HumanName.Use.OFFICIAL, null,
                            "Apellido", List.of("Nombre"), null, null, null))
            ) :
            new DerivationReportDTO.PatientInfo(List.of());

    List<DerivationReportDTO.ConditionInfo> diagnostics = createDiagnostics(diagnosticCount);
    List<DerivationReportDTO.MedicationInfo> medications = createMedications(medicationCount);
    List<DerivationReportDTO.AllergyInfo> allergies = createAllergies(allergyCount);

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            patientInfo,
            diagnostics,
            medications,
            allergies
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    GenerateDerivationReportUsecase.Output output = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    ).get();

    DerivationReportDTO result = output.derivationReport();

    assertEquals(diagnosticCount, result.diagnostic().size());
    assertEquals(medicationCount, result.medications().size());
    assertEquals(allergyCount, result.allergies().size());
    assertEquals(hasPatientName, !result.patient().name().isEmpty());
  }

  @Test
  void shouldHandleLongMedicationInstructions() throws ExecutionException, InterruptedException {
    String patientId = "long-instructions";

    String longInstruction = "Aplicar 10 unidades por vía subcutánea cada mañana antes del desayuno " +
            "y 5 unidades antes de la cena, evitando aplicar en el mismo sitio consecutivamente. " +
            "Rotar lugares de aplicación entre abdomen, muslos y brazos.";

    DerivationReportDTO.MedicationInfo medicationInfo = new DerivationReportDTO.MedicationInfo(
            List.of(new Dosage(null, longInstruction, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null))
    );

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            new DerivationReportDTO.PatientInfo(List.of(
                    new HumanName(HumanName.Use.OFFICIAL, null, "Paciente", List.of("Con"),
                            null, null, null))),
            List.of(), List.of(medicationInfo), List.of()
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    GenerateDerivationReportUsecase.Output output = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    ).get();

    String instruction = output.derivationReport().medications().get(0).dosageInstruction().get(0).text();
    assertEquals(longInstruction, instruction);
  }

  @Test
  void shouldHandleMultipleDosageInstructions() throws ExecutionException, InterruptedException {
    String patientId = "multiple-dosage";

    DerivationReportDTO.MedicationInfo medicationInfo = new DerivationReportDTO.MedicationInfo(
            List.of(
                    new Dosage(null, "Tomar 1 comprimido por la mañana",  null, null,
                            null, null, null, null, null,
                            null, null, null, null, null,
                            null, null, null),
                    new Dosage(null, "Tomar 1 comprimido por la noche",  null, null,
                            null, null, null, null, null,
                            null, null, null, null, null,
                            null, null, null)
            )
    );

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            new DerivationReportDTO.PatientInfo(List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Paciente", List.of("Con"),
                    null, null, null))),
            List.of(),
            List.of(medicationInfo),
            List.of()
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    GenerateDerivationReportUsecase.Output output = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    ).get();

    assertEquals(2, output.derivationReport().medications().get(0).dosageInstruction().size());
    assertEquals("Tomar 1 comprimido por la noche",
            output.derivationReport().medications().get(0).dosageInstruction().get(1).text());
  }

  @Test
  void shouldHandleSpecialCharacters() throws ExecutionException, InterruptedException {
    String patientId = "special-chars";

    DerivationReportDTO.PatientInfo patientInfo = new DerivationReportDTO.PatientInfo(
            List.of(new HumanName(HumanName.Use.OFFICIAL, null, "González-Márquez",
                    List.of("María José", "Ángela"), null, null, null))
    );

    DerivationReportDTO.ConditionInfo conditionInfo = new DerivationReportDTO.ConditionInfo(
            new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null, "123456",
                    "Enfermedad de Crohn (íleon-colónica)", null)),
                    null)
    );

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            patientInfo,
            List.of(conditionInfo),
            List.of(),
            List.of()
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    GenerateDerivationReportUsecase.Output output = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    ).get();

    assertEquals("María José Ángela González-Márquez",
            output.derivationReport().patient().name().get(0).given().get(0) + " " +
                    output.derivationReport().patient().name().get(0).given().get(1) + " " +
                    output.derivationReport().patient().name().get(0).family());

    assertEquals("Enfermedad de Crohn (íleon-colónica)",
            output.derivationReport().diagnostic().get(0).code().coding().get(0).display());
  }

  @Test
  void shouldHandleEmptyReport() throws ExecutionException, InterruptedException {
    String patientId = "empty-report";

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            new DerivationReportDTO.PatientInfo(List.of()),
            List.of(),
            List.of(),
            List.of()
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    GenerateDerivationReportUsecase.Output output = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    ).get();

    DerivationReportDTO result = output.derivationReport();

    assertTrue(result.patient().name().isEmpty());
    assertTrue(result.diagnostic().isEmpty());
    assertTrue(result.medications().isEmpty());
    assertTrue(result.allergies().isEmpty());
  }

  @Test
  void shouldHandleLargeReport() throws ExecutionException, InterruptedException {
    String patientId = "large-report";

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            new DerivationReportDTO.PatientInfo(List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Apellido",
                    List.of("Paciente"), null, null, null))), createDiagnostics(50),
            createMedications(20), createAllergies(10)
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    GenerateDerivationReportUsecase.Output output = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    ).get();

    assertEquals(50, output.derivationReport().diagnostic().size());
    assertEquals(20, output.derivationReport().medications().size());
    assertEquals(10, output.derivationReport().allergies().size());
  }

  @Test
  void inputRecord_shouldStorePatientId() {
    String patientId = "test-id";
    GenerateDerivationReportUsecase.Input input = new GenerateDerivationReportUsecase.Input(patientId);
    assertEquals(patientId, input.patienId());
  }

  @Test
  void outputRecord_shouldStoreDerivationReport() {
    DerivationReportDTO report = new DerivationReportDTO(
            null, List.of(), List.of(), List.of()
    );
    GenerateDerivationReportUsecase.Output output = new GenerateDerivationReportUsecase.Output(report);
    assertEquals(report, output.derivationReport());
  }

//  // ================== Prueba de manejo de errores ==================

  @Test
  void shouldHandleServiceExceptions() {
    String patientId = "error-patient";
    when(reportService.generateDerivationReport(eq(patientId)))
            .thenThrow(new RuntimeException("Error de base de datos"));

    CompletableFuture<GenerateDerivationReportUsecase.Output> future = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    );

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertTrue(exception.getCause() instanceof RuntimeException);
    assertEquals("Error de base de datos", exception.getCause().getMessage());
  }

    @Test
  void shouldHandleIncompleteData() throws ExecutionException, InterruptedException {
    String patientId = "incomplete-data";

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            new DerivationReportDTO.PatientInfo(List.of()),
            List.of(new DerivationReportDTO.ConditionInfo(
                    new CodeableConcept(List.of(new Coding(null, null, null, null,
                            null)), null)
            )),
            List.of(new DerivationReportDTO.MedicationInfo(
                    List.of(new Dosage(null, null, null, null, null,
                            null, null, null, null, null,
                            null, null, null, null, null,
                            null, null))
            )),
            List.of(new DerivationReportDTO.AllergyInfo(
                    new CodeableConcept(List.of(new Coding("system", null, null, null,
                            null)), null)
            ))
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    GenerateDerivationReportUsecase.Output output = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    ).get();

    DerivationReportDTO result = output.derivationReport();

    assertTrue(result.patient().name().isEmpty());
    assertNull(result.diagnostic().get(0).code().coding().get(0).system());
    assertNull(result.medications().get(0).dosageInstruction().get(0).text());
    assertNull(result.allergies().get(0).code().coding().get(0).display());
  }

  @Test
  void shouldMaintainDataRelationships() throws ExecutionException, InterruptedException {
    String patientId = "data-relationships";

    String diabetesCode = "44054006";
    String insulinInstruction = "Aplicar 10 unidades subcutáneas antes del desayuno";

    DerivationReportDTO expectedReport = new DerivationReportDTO(
            new DerivationReportDTO.PatientInfo(List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Rodríguez",
                    List.of("María"), null, null, null))),
            List.of(new DerivationReportDTO.ConditionInfo(
                    new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null, diabetesCode,
                            "Diabetes", null)), null)
            )),
            List.of(new DerivationReportDTO.MedicationInfo(
                    List.of(new Dosage(null, insulinInstruction, null, null,
                            null, null, null, null, null,
                            null, null, null, null, null,
                            null, null, null))
            )),
            List.of(new DerivationReportDTO.AllergyInfo(
                    new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null, "91930004",
                            "Penicilina", null)), null)
            ))
    );

    when(reportService.generateDerivationReport(eq(patientId)))
            .thenReturn(expectedReport);

    GenerateDerivationReportUsecase.Output output = generateDerivationReportUsecase.execute(
            new GenerateDerivationReportUsecase.Input(patientId)
    ).get();

    DerivationReportDTO result = output.derivationReport();

    assertEquals("Diabetes", result.diagnostic().get(0).code().coding().get(0).display());
    assertEquals(insulinInstruction, result.medications().get(0).dosageInstruction().get(0).text());
    assertEquals("Penicilina", result.allergies().get(0).code().coding().get(0).display());
  }

  private static Stream<Arguments> provideReportVariations() {
    return Stream.of(
            // diagnosticCount, medicationCount, allergyCount, hasPatientName
            Arguments.of(0, 0, 0, true),   // Solo paciente
            Arguments.of(1, 0, 0, true),    // Un diagnóstico
            Arguments.of(0, 1, 0, true),    // Un medicamento
            Arguments.of(0, 0, 1, true),    // Una alergia
            Arguments.of(5, 3, 2, true),    // Múltiples elementos
            Arguments.of(0, 0, 0, false)    // Sin nombre de paciente
    );
  }

  private List<DerivationReportDTO.ConditionInfo> createDiagnostics(int count) {
    return java.util.stream.IntStream.range(0, count)
            .mapToObj(i -> new DerivationReportDTO.ConditionInfo(
                    new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null,
                            "CODE-" + i, "Diagnóstico " + i, null)),null)))
            .toList();
  }

  private List<DerivationReportDTO.MedicationInfo> createMedications(int count) {
    return java.util.stream.IntStream.range(0, count)
            .mapToObj(i -> new DerivationReportDTO.MedicationInfo(
                    List.of(new Dosage(null, "Instrucción de dosificación " + i,
                            null, null, null, null
                    , null, null, null, null, null, null,
                            null, null, null, null,
                            null))
            ))
            .toList();
  }

  private List<DerivationReportDTO.AllergyInfo> createAllergies(int count) {
    return java.util.stream.IntStream.range(0, count)
            .mapToObj(i -> new DerivationReportDTO.AllergyInfo(
                    new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null,
                            "ALL-" + i, "Alergia " + i, null)), null))).toList();
  }
}
