package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.Address;
import cesim.individuals.domain.entities.HumanName;
import cesim.individuals.domain.entities.Identifier;
import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.report.outputDTO.AdvancedSearchResultsDTO;
import cesim.individuals.domain.entities.report.specInput.AdvancedSearchRequestSpec;
import cesim.individuals.domain.usecases.report.dependencies.AdvancedSearchService;
import cesim.individuals.domain.utils.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import cesim.individuals.domain.utils.Pageable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatList;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdvancedSearchUseCaseTest {

  private final ObjectMapper mapper;

  public AdvancedSearchUseCaseTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Mock
  private AdvancedSearchService advancedSearchService;

  @InjectMocks
  private AdvancedSearchUseCase advancedSearchUseCase;

  @Test
  void execute_shouldReturnPaginatedResults() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");

    AdvancedSearchRequestSpec searchRequest = new AdvancedSearchRequestSpec(
            "María Elena", "92020254321", "Diabetes",
            LocalDate.of(1990, 1, 1),
            LocalDate.of(2000, 12, 31)
    );

    Patient patient = new Patient(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            List.of(new Identifier(null, null, "http://minsap.cu/ci",
                    "92020254321", null, null)),
            true,
            List.of(new HumanName(HumanName.Use.OFFICIAL, null,"Rodríguez",
                    List.of("María", "Elena"), null, null, null)
            ),null, Patient.Gender.FEMALE, LocalDate.of(1992, 2, 2),
            List.of(new Address(null, null, null, null, "La Habana",
              null, null, null, null,null,null)
            ), null, null, null
    );

    Page<Patient> patientPage = new Page<>(1, 0, 10, List.of(patient));
    AdvancedSearchResultsDTO expectedResults = new AdvancedSearchResultsDTO(patientPage);

    when(advancedSearchService.searchPatients(eq(pageable), eq(searchRequest)))
            .thenReturn(expectedResults);

    CompletableFuture<AdvancedSearchUseCase.Output> future = advancedSearchUseCase.execute(
            new AdvancedSearchUseCase.Input(pageable, searchRequest)
    );

    AdvancedSearchUseCase.Output output = future.get();

    assertNotNull(output);
    assertEquals(1, output.resultsDTO().patientPage().items().size());

    Patient resultPatient = output.resultsDTO().patientPage().items().get(0);
    assertEquals("92020254321", resultPatient.identifier().get(0).value());

    String fullName = resultPatient.name().get(0).given().get(0) +
            " " + resultPatient.name().get(0).given().get(1);
    assertEquals("María Elena", fullName);
    assertEquals(LocalDate.of(1992, 2, 2), resultPatient.birthDate());

    verify(advancedSearchService).searchPatients(pageable, searchRequest);
  }

  @Test
  void shouldHandleEmptyResults() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 0, "id", "asc");

    AdvancedSearchRequestSpec searchRequest = new AdvancedSearchRequestSpec(
            "Nombre Inexistente",
            null,
            null,
            null,
            null
    );

    Page<Patient> emptyPage = new Page<>(0, 0, 0, List.of());
    AdvancedSearchResultsDTO expectedResults = new AdvancedSearchResultsDTO(emptyPage);

    when(advancedSearchService.searchPatients(any(), any()))
            .thenReturn(expectedResults);

    CompletableFuture<AdvancedSearchUseCase.Output> future = advancedSearchUseCase.execute(
            new AdvancedSearchUseCase.Input(pageable, searchRequest)
    );

    AdvancedSearchUseCase.Output output = future.get();

    assertTrue(output.resultsDTO().patientPage().items().isEmpty());
    assertEquals(0, output.resultsDTO().patientPage().totalPages());
  }

  @Test
  void shouldHandlePartialMatches() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");

    AdvancedSearchRequestSpec searchRequest = new AdvancedSearchRequestSpec(
            "María",
            null,
            null,
            null,
            null
    );

    Patient patient1 = new Patient(UUID.randomUUID().toString(),
            List.of(new Identifier(null, null, "http://minsap.cu/ci",
                    "92020254321", null, null)),
            true,
            List.of(new HumanName(HumanName.Use.OFFICIAL, null,"Rodríguez",
                    List.of("María", "Elena"), null, null, null)
            ),null, Patient.Gender.FEMALE, LocalDate.of(1992, 2, 2),
            List.of(new Address(null, null, null, null, "La Habana",
                    null, null, null, null,null,null)
            ), null, null, null
    );

    Patient patient2 = new Patient(UUID.randomUUID().toString(),
            List.of(new Identifier(null, null, "http://minsap.cu/ci",
                    "91010112345", null, null)),
            true,
            List.of(new HumanName(HumanName.Use.OFFICIAL, null,"Fernández",
                    List.of("María", "José"), null, null, null)
            ),null, Patient.Gender.FEMALE, LocalDate.of(1992, 1, 1),
            List.of(new Address(null, null, null, null, "Pinar del Río",
                    null, null, null, null,null,null)
            ), null, null, null
    );

    Page<Patient> patientPage = new Page<>(0, 10, 2, List.of(patient1, patient2));
    AdvancedSearchResultsDTO expectedResults = new AdvancedSearchResultsDTO(patientPage);

    when(advancedSearchService.searchPatients(any(), any()))
            .thenReturn(expectedResults);

    CompletableFuture<AdvancedSearchUseCase.Output> future = advancedSearchUseCase.execute(
            new AdvancedSearchUseCase.Input(pageable, searchRequest)
    );

    AdvancedSearchUseCase.Output output = future.get();

    assertEquals(2, output.resultsDTO().patientPage().items().size());
    assertTrue(output.resultsDTO().patientPage().items()
            .stream().allMatch(p -> {
              String fullName = p.name().get(0).given().get(0) +
                      " " + p.name().get(0).family();

              return fullName.contains("María");
            })
    );
  }

  @Test
  void inputRecord_shouldStoreParametersCorrectly() {
    Pageable pageable = new Pageable(0, 10, "id", "asc");

    AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
            "María", null, null, null, null
    );

    AdvancedSearchUseCase.Input input = new AdvancedSearchUseCase.Input(pageable, spec);

    assertEquals(pageable, input.pageable());
    assertEquals(spec, input.searchRequest());
    assertEquals("María", input.searchRequest().name());
  }

  @Test
  void outputRecord_shouldStoreResultsCorrectly() {
    Page<Patient> patientPage = new Page<>(0, 10, 0, List.of());
    AdvancedSearchResultsDTO results = new AdvancedSearchResultsDTO(patientPage);

    AdvancedSearchUseCase.Output output = new AdvancedSearchUseCase.Output(results);

    assertEquals(results, output.resultsDTO());
    assertEquals(0, output.resultsDTO().patientPage().items().size());
  }

  @Captor
  private ArgumentCaptor<AdvancedSearchRequestSpec> specCaptor;

  @ParameterizedTest
  @MethodSource("searchCriteriaProvider")
  void shouldHandleVariousSearchCriteria(String name, String identification, String diagnosis) {
    LocalDate fromDate = LocalDate.of(1990, 1, 1);
    LocalDate toDate = LocalDate.now();

    AdvancedSearchRequestSpec requestSpec = new AdvancedSearchRequestSpec(
            name, identification, diagnosis, fromDate, toDate
    );

    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AdvancedSearchUseCase.Input input = new AdvancedSearchUseCase.Input(pageable, requestSpec);

    List<Patient> patients = Collections.singletonList(
            new Patient(
                    "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
                    null,
                    true,
                    List.of(new HumanName(HumanName.Use.OFFICIAL, null, "Rodríguez",
                            List.of("María", "Elena"),null, null, null)),
                    null,
                    Patient.Gender.FEMALE,
                    LocalDate.of(1992, 2, 2),
                    null,
                    null,
                    null,
                    null
            )
    );

    Page<Patient> patientPage = new Page<>(0, 1, 1, patients);
    AdvancedSearchResultsDTO mockResults = new AdvancedSearchResultsDTO(patientPage);

    when(advancedSearchService.searchPatients(any(), any()))
            .thenReturn(mockResults);

    AdvancedSearchUseCase.Output output = advancedSearchUseCase.execute(input).join();

    assertThatList(output.resultsDTO().patientPage().items()).hasSize(1);
    assertThatList(output.resultsDTO().patientPage().items().get(0).name().get(0).given())
            .containsExactly("María", "Elena");

    // 7. Verificar criterios enviados al servicio
    verify(advancedSearchService).searchPatients(eq(pageable), specCaptor.capture());

    AdvancedSearchRequestSpec capturedSpec = specCaptor.getValue();
    assertThat(capturedSpec.name()).isEqualTo(name);
    assertThat(capturedSpec.identification()).isEqualTo(identification);
    assertThat(capturedSpec.diagnosis()).isEqualTo(diagnosis);
  }

  private static Stream<Arguments> searchCriteriaProvider() {
    return Stream.of(
            Arguments.of("María", null, null),          // Solo nombre
            Arguments.of(null, "92020254321", null),    // Solo CI
            Arguments.of(null, null, "Diabetes"),       // Solo diagnóstico
            Arguments.of("María", "92020254321", "Diabetes") // Todos los criterios
    );
  }

  @Test
  void shouldFilterByDateRange() {
    LocalDate fromDate = LocalDate.of(1990, 1, 1);
    LocalDate toDate = LocalDate.of(1995, 12, 31);

    AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
            null, null, null, fromDate, toDate
    );

    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AdvancedSearchUseCase.Input input = new AdvancedSearchUseCase.Input(pageable, spec);

    List<Patient> patientsInRange = Arrays.asList(
            createPatient("Paciente 1", LocalDate.of(1990, 1, 1)),
            createPatient("Paciente 2", LocalDate.of(1993, 6, 15)),
            createPatient("Paciente 3", LocalDate.of(1995, 12, 31))
    );

    when(advancedSearchService.searchPatients(any(), any()))
            .thenReturn(new AdvancedSearchResultsDTO(
                    new Page<>(0, patientsInRange.size(), patientsInRange.size(), patientsInRange)
            ));

    AdvancedSearchUseCase.Output output = advancedSearchUseCase.execute(input).join();

    List<Patient> resultPatients = output.resultsDTO().patientPage().items();

    assertThatList(resultPatients)
            .as("Solo pacientes entre 1990-01-01 y 1995-12-31")
            .hasSize(3);

    List<LocalDate> birthDates = resultPatients.stream()
            .map(Patient::birthDate)
            .collect(Collectors.toList());

    assertThat(birthDates)
            .containsExactly(
                    LocalDate.of(1990, 1, 1),
                    LocalDate.of(1993, 6, 15),
                    LocalDate.of(1995, 12, 31)
            );

    List<String> firstNames = resultPatients.stream()
            .map(p -> p.name().get(0).given().get(0))
            .collect(Collectors.toList());

    assertThat(firstNames)
            .containsExactly("Paciente 1", "Paciente 2", "Paciente 3");

    assertThat(firstNames)
            .doesNotContain("Paciente 4", "Paciente 5");

    verify(advancedSearchService).searchPatients(eq(pageable), specCaptor.capture());
    AdvancedSearchRequestSpec capturedSpec = specCaptor.getValue();

    assertThat(capturedSpec.fromDate()).isEqualTo(fromDate);
    assertThat(capturedSpec.toDate()).isEqualTo(toDate);
  }

  private Patient createPatient(String name, LocalDate birthDate) {
    return new Patient(
            UUID.randomUUID().toString(),
            null,
            true,
            Collections.singletonList(
                    new HumanName(
                            HumanName.Use.OFFICIAL,
                            null,
                            "Apellido",
                            Collections.singletonList(name),
                            null,
                            null,
                            null
                    )
            ),
            null,
            Patient.Gender.OTHER,
            birthDate,
            null,
            null,
            null,
            null
    );
  }
}
