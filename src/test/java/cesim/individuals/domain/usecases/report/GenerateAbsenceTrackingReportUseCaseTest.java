package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.report.outputDTO.AbsenceReportDTO;
import cesim.individuals.domain.entities.report.specInput.AbsenceTrackingSpec;
import cesim.individuals.domain.usecases.report.dependencies.AbsenceTrackingService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenerateAbsenceTrackingReportUseCaseTest {

  @Mock
  private AbsenceTrackingService trackingService;

  @InjectMocks
  private GenerateAbsenceTrackingReportUseCase generateAbsenceTrackingReportUseCase;

  @Test
  void execute_shouldReturnAbsencesForValidRange() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(
            LocalDate.of(2023, 10, 1),
            LocalDate.of(2023, 10, 31)
    );

    AbsenceReportDTO expectedDTO = new AbsenceReportDTO(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "María Elena", LocalDateTime.parse("2023-10-05T08:00:00"));
    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 10, 1, List.of(expectedDTO));

    when(trackingService.findAbsences(eq(pageable), eq(spec)))
            .thenReturn(expectedPage);

    CompletableFuture<GenerateAbsenceTrackingReportUseCase.OutPut> future = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    );

    GenerateAbsenceTrackingReportUseCase.OutPut output = future.get();
    Page<AbsenceReportDTO> result = output.reportDTO();

    assertNotNull(result);
    assertEquals(1, result.items().size());

    AbsenceReportDTO resultDTO = result.items().get(0);
    assertEquals("bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", resultDTO.patientId());
    assertEquals("María Elena", resultDTO.patientName());
    assertEquals(LocalDateTime.parse("2023-10-05T08:00:00"), resultDTO.scheduledDate());

    verify(trackingService).findAbsences(pageable, spec);
  }

  @Test
  void shouldReturnAbsencesOnSingleDay() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    LocalDate testDate = LocalDate.of(2023, 10, 5);
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(testDate, testDate);

    AbsenceReportDTO expectedDTO = new AbsenceReportDTO(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "María Elena", LocalDateTime.parse("2023-10-05T08:00:00")
    );
    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 10, 1, List.of(expectedDTO));

    when(trackingService.findAbsences(eq(pageable), eq(spec)))
            .thenReturn(expectedPage);

    GenerateAbsenceTrackingReportUseCase.OutPut output = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    ).get();

    assertEquals(1, output.reportDTO().items().size());
    assertEquals("María Elena", output.reportDTO().items().get(0).patientName());
  }

  @Test
  void shouldHandleMinimumDate() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(
            LocalDate.of(1900, 1, 1),
            LocalDate.of(1900, 12, 31)
    );

    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 10, 0, List.of());

    when(trackingService.findAbsences(eq(pageable), eq(spec)))
            .thenReturn(expectedPage);

    GenerateAbsenceTrackingReportUseCase.OutPut output = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    ).get();

    assertTrue(output.reportDTO().items().isEmpty());
  }

  @Test
  void shouldHandleMaximumDate() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(
            LocalDate.of(2100, 1, 1),
            LocalDate.of(2100, 12, 31)
    );

    AbsenceReportDTO expectedDTO = new AbsenceReportDTO(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "María Elena",
            LocalDateTime.parse("2100-06-15T10:00:00")
    );
    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 10, 1, List.of(expectedDTO));

    when(trackingService.findAbsences(eq(pageable), eq(spec)))
            .thenReturn(expectedPage);

    GenerateAbsenceTrackingReportUseCase.OutPut output = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    ).get();

    assertEquals(1, output.reportDTO().items().size());
  }

  @Test
  void shouldHandleInvalidDateRange() throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(
            LocalDate.of(2023, 10, 31),
            LocalDate.of(2023, 10, 1) // startDate > endDate (inválido)
    );

    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 10, 0, List.of());

    when(trackingService.findAbsences(eq(pageable), eq(spec)))
            .thenReturn(expectedPage);

    GenerateAbsenceTrackingReportUseCase.OutPut output = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    ).get();

    assertTrue(output.reportDTO().items().isEmpty());
  }

  @ParameterizedTest
  @MethodSource("provideDateRangesForAbsence")
  void shouldReturnCorrectResultsForDateRanges(LocalDate startDate, LocalDate endDate, int expectedCount)
          throws ExecutionException, InterruptedException {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(startDate, endDate);

    AbsenceReportDTO dtoInRange = new AbsenceReportDTO(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "María Elena",
            LocalDateTime.parse("2023-10-05T08:00:00")
    );

    AbsenceReportDTO dtoOutOfRange = new AbsenceReportDTO(
            "another-id",
            "Otro Paciente",
            LocalDateTime.parse("2023-11-05T08:00:00")
    );

    List<AbsenceReportDTO> content = expectedCount > 0 ? List.of(dtoInRange) : List.of();
    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 10, content.size(),content);

    when(trackingService.findAbsences(eq(pageable), eq(spec))).thenReturn(expectedPage);

    GenerateAbsenceTrackingReportUseCase.OutPut output = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    ).get();

    assertEquals(expectedCount, output.reportDTO().items().size());
  }

  private static Stream<Arguments> provideDateRangesForAbsence() {
    return Stream.of(
            Arguments.of(LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 31), 1), // Dentro del rango
            Arguments.of(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 30), 0),  // Fuera del rango
            Arguments.of(LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 5), 1),   // Mismo día
            Arguments.of(LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 4), 0),   // Antes del evento
            Arguments.of(LocalDate.of(2023, 10, 6), LocalDate.of(2023, 10, 10), 0)   // Después del evento
    );
  }

  @Test
  void shouldHandlePaginationCorrectly() throws ExecutionException, InterruptedException {
    Pageable firstPage = new Pageable(0, 1, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(
            LocalDate.of(2023, 1, 1),
            LocalDate.of(2023, 12, 31)
    );

    AbsenceReportDTO dto1 = new AbsenceReportDTO("id1", "Paciente 1",
            LocalDateTime.parse("2023-06-01T09:00:00"));
    Page<AbsenceReportDTO> firstExpected = new Page<>(0, 1, 2, List.of(dto1));

    Pageable secondPage = new Pageable(1, 1, "id", "asc");
    AbsenceReportDTO dto2 = new AbsenceReportDTO("id2", "Paciente 2",
            LocalDateTime.parse("2023-07-15T10:00:00"));
    Page<AbsenceReportDTO> secondExpected = new Page<>(1, 1, 2, List.of(dto2));

    when(trackingService.findAbsences(eq(firstPage), eq(spec))).thenReturn(firstExpected);
    when(trackingService.findAbsences(eq(secondPage), eq(spec))).thenReturn(secondExpected);

    GenerateAbsenceTrackingReportUseCase.OutPut output1 = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(firstPage, spec)
    ).get();

    assertEquals(1, output1.reportDTO().items().size());
    assertEquals("Paciente 1", output1.reportDTO().items().get(0).patientName());

    GenerateAbsenceTrackingReportUseCase.OutPut output2 = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(secondPage, spec)
    ).get();

    assertEquals(1, output2.reportDTO().items().size());
    assertEquals("Paciente 2", output2.reportDTO().items().get(0).patientName());
  }

  @Test
  void inputRecord_shouldStorePageableAndSpec() {
    Pageable pageable = new Pageable(1, 20, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(LocalDate.now(), LocalDate.now().plusDays(7));
    GenerateAbsenceTrackingReportUseCase.Input input = new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec);

    assertEquals(pageable, input.pageable());
    assertEquals(spec, input.spec());
    assertEquals(1, input.pageable().page());
    assertEquals(20, input.pageable().size());
  }

  @Test
  void outputRecord_shouldStoreReportDTO() {
    Page<AbsenceReportDTO> reportPage = new Page<>(0, 10, 0, List.of());
    GenerateAbsenceTrackingReportUseCase.OutPut output = new GenerateAbsenceTrackingReportUseCase.OutPut(reportPage);
    assertEquals(reportPage, output.reportDTO());
  }

    @Test
  void shouldHandleServiceExceptions() {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(LocalDate.now(), LocalDate.now().plusDays(7));

    when(trackingService.findAbsences(any(), any()))
            .thenThrow(new RuntimeException("Error de base de datos"));

    CompletableFuture<GenerateAbsenceTrackingReportUseCase.OutPut> future =
            generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    );

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertTrue(exception.getCause() instanceof RuntimeException);
    assertEquals("Error de base de datos", exception.getCause().getMessage());
  }

  @Test
  void shouldIncludeAbsencesOnBoundaryDates() throws Exception {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(
            LocalDate.of(2023, 10, 5),
            LocalDate.of(2023, 10, 5)
    );

    AbsenceReportDTO dto = new AbsenceReportDTO(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "María Elena",
            LocalDateTime.parse("2023-10-05T00:00:00")
    );

    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 10, 1, List.of(dto));

    when(trackingService.findAbsences(any(), any())).thenReturn(expectedPage);

    assertEquals(1, generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    ).get().reportDTO().items().size());
  }

  @Test
  void shouldHandleLargeNumberOfAbsences() throws Exception {
    Pageable pageable = new Pageable(0, 100, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(
            LocalDate.of(2023, 1, 1),
            LocalDate.of(2023, 12, 31)
    );

    List<AbsenceReportDTO> absences = IntStream.range(0, 100)
            .mapToObj(i -> new AbsenceReportDTO(
                    "id-" + i,
                    "Paciente " + i,
                    LocalDateTime.of(2023, 6, 15, 9, 0).plusDays(i)
            ))
            .collect(Collectors.toList());

    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 100, 100, absences);

    when(trackingService.findAbsences(any(), any())).thenReturn(expectedPage);

    assertEquals(100, generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    ).get().reportDTO().items().size());
  }

  @Test
  void shouldHandleAbsencesWithoutScheduledDate() throws Exception {
    Pageable pageable = new Pageable(0, 10, "id", "asc");
    AbsenceTrackingSpec spec = new AbsenceTrackingSpec(
            LocalDate.of(2023, 10, 1),
            LocalDate.of(2023, 10, 31)
    );

    AbsenceReportDTO dto = new AbsenceReportDTO(
            "id-unknown",
            "Paciente Desconocido",
            null
    );

    Page<AbsenceReportDTO> expectedPage = new Page<>(0, 10, 1, List.of(dto));

    when(trackingService.findAbsences(any(), any())).thenReturn(expectedPage);

    AbsenceReportDTO result = generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(pageable, spec)
    ).get().reportDTO().items().get(0);

    assertNull(result.scheduledDate());
  }
}
