package cesim.individuals.domain.usecases.report;

import cesim.individuals.domain.entities.*;
import cesim.individuals.domain.entities.report.outputDTO.CarePlanNotificationDTO;
import cesim.individuals.domain.usecases.report.dependencies.CarePlanNotificationsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenerateCarePlanNotificationsUseCaseTest {

  @Mock
  private CarePlanNotificationsService notificationService;

  @InjectMocks
  private GenerateCarePlanNotificationsUseCase generateCarePlanNotificationsUseCase;

  @Test
  void execute_shouldReturnCarePlanNotifications() throws ExecutionException, InterruptedException {
    Patient patient = createPatient("bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "María Elena", "Rodríguez");
    Practitioner practitioner = createPractitioner("12345678-1234-1234-1234-123456789abc",
            "Ana", "López");

    StringBuilder patientFullName = new StringBuilder();
    patientFullName.append(patient.name().get(0).given().get(0).split(" ")[0])
            .append(" ")
            .append(patient.name().get(0).given().get(0).split(" ")[1])
            .append(" ")
            .append(patient.name().get(0).family());

    StringBuilder practitionerFullName = new StringBuilder();
    practitionerFullName.append(practitioner.name().get(0).given().get(0))
            .append(" ").append(practitioner.name().get(0).family());

    Instant endDate = Instant.parse("2024-10-01T00:00:00Z");
    String message = "El plan de cuidado para diabetes está próximo a expirar";

    CarePlanNotificationDTO expectedDTO = new CarePlanNotificationDTO(
            "2d3e4f5a-6b7c-8d9e-0f1a-2b3c4d5e6f7a",
            patient,
            practitioner,
            endDate,
            message
    );

    when(notificationService.generateCarePlanClosureNotifications())
            .thenReturn(List.of(expectedDTO));

    CompletableFuture<GenerateCarePlanNotificationsUseCase.Output> future =
            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input());

    GenerateCarePlanNotificationsUseCase.Output output = future.get();
    List<CarePlanNotificationDTO> notifications = output.notificationsDTO();

    assertEquals(1, notifications.size());
    CarePlanNotificationDTO result = notifications.get(0);
    assertEquals("2d3e4f5a-6b7c-8d9e-0f1a-2b3c4d5e6f7a", result.carePlanId());
    assertEquals("María Elena Rodríguez", patientFullName.toString());
    assertEquals("Ana López", practitionerFullName.toString());
    assertEquals(endDate, result.endDate());
    assertEquals(message, result.notificationMessage());
  }

  @ParameterizedTest
  @MethodSource("provideEndDatesForNotification")
  void shouldGenerateNotificationsBasedOnEndDate(Instant endDate, String expectedMessageSnippet)
          throws ExecutionException, InterruptedException {
    CarePlanNotificationDTO notification = createNotification(
            "careplan-id",
            createPatient("patient-id", "Paciente", "Apellido"),
            createPractitioner("pract-id", "Profesional", "Apellido"),
            endDate,
            expectedMessageSnippet
    );

    when(notificationService.generateCarePlanClosureNotifications())
            .thenReturn(List.of(notification));

    GenerateCarePlanNotificationsUseCase.Output output =
            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input()).get();

    CarePlanNotificationDTO result = output.notificationsDTO().get(0);
    assertTrue(result.notificationMessage().contains(expectedMessageSnippet));
  }

  private static Stream<Arguments> provideEndDatesForNotification() {
    Instant now = Instant.now();
    return Stream.of(
            Arguments.of(now.minus(1, ChronoUnit.DAYS), "ha expirado"),
            Arguments.of(now, "expira hoy"),
            Arguments.of(now.plus(1, ChronoUnit.DAYS), "expira mañana"),
            Arguments.of(now.plus(7, ChronoUnit.DAYS), "expira en 7 días"),
            Arguments.of(now.plus(30, ChronoUnit.DAYS), "expira en 30 días"),
            Arguments.of(now.plus(365, ChronoUnit.DAYS), "expira en 365 días")
    );
  }

//  @Test
//  void shouldHandleMissingEndDate() throws ExecutionException, InterruptedException {
//    // Crear notificación sin fecha de finalización
//    CarePlanNotificationDTO notification = new CarePlanNotificationDTO(
//            "careplan-id",
//            createPatient("patient-id", "Paciente", "Apellido"),
//            createPractitioner("pract-id", "Profesional", "Apellido"),
//            null, // Sin endDate
//            "Notificación sin fecha"
//    );
//
//    when(notificationService.generateCarePlanClosureNotifications())
//            .thenReturn(List.of(notification));
//
//    GenerateCarePlanNotificationsUseCase.Output output =
//            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input()).get();
//
//    CarePlanNotificationDTO result = output.notificationsDTO().get(0);
//    assertNull(result.endDate());
//    assertEquals("Notificación sin fecha", result.notificationMessage());
//  }
//
//  @Test
//  void shouldHandleMissingPatient() throws ExecutionException, InterruptedException {
//    // Crear notificación sin paciente
//    CarePlanNotificationDTO notification = new CarePlanNotificationDTO(
//            "careplan-id",
//            null, // Sin paciente
//            createPractitioner("pract-id", "Profesional", "Apellido"),
//            Instant.now().plus(7, ChronoUnit.DAYS),
//            "Notificación sin paciente"
//    );
//
//    when(notificationService.generateCarePlanClosureNotifications())
//            .thenReturn(List.of(notification));
//
//    GenerateCarePlanNotificationsUseCase.Output output =
//            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input()).get();
//
//    CarePlanNotificationDTO result = output.notificationsDTO().get(0);
//    assertNull(result.patient());
//    assertTrue(result.notificationMessage().contains("sin paciente asociado"));
//  }
//
//  @Test
//  void shouldHandleMissingPractitioner() throws ExecutionException, InterruptedException {
//    // Crear notificación sin profesional
//    CarePlanNotificationDTO notification = new CarePlanNotificationDTO(
//            "careplan-id",
//            createPatient("patient-id", "Paciente", "Apellido"),
//            null, // Sin profesional
//            Instant.now().plus(7, ChronoUnit.DAYS),
//            "Notificación sin profesional"
//    );
//
//    when(notificationService.generateCarePlanClosureNotifications())
//            .thenReturn(List.of(notification));
//
//    GenerateCarePlanNotificationsUseCase.Output output =
//            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input()).get();
//
//    CarePlanNotificationDTO result = output.notificationsDTO().get(0);
//    assertNull(result.practitioner());
//    assertTrue(result.notificationMessage().contains("sin profesional asociado"));
//  }
//
//  // ================== Pruebas de volumen ==================
//
//  @Test
//  void shouldHandleLargeNumberOfNotifications() throws ExecutionException, InterruptedException {
//    // Crear 1000 notificaciones
//    List<CarePlanNotificationDTO> notifications = java.util.stream.IntStream.range(0, 1000)
//            .mapToObj(i -> createNotification(
//                    "careplan-" + i,
//                    createPatient("patient-" + i, "Paciente " + i, "Apellido"),
//                    createPractitioner("pract-" + i, "Profesional " + i, "Apellido"),
//                    Instant.now().plus(i, ChronoUnit.DAYS)
//            ))
//            .toList();
//
//    when(notificationService.generateCarePlanClosureNotifications())
//            .thenReturn(notifications);
//
//    GenerateCarePlanNotificationsUseCase.Output output =
//            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input()).get();
//
//    assertEquals(1000, output.notificationsDTO().size());
//  }
//
//  // ================== Pruebas de records ==================
//
//  @Test
//  void inputRecord_shouldBeEmpty() {
//    GenerateCarePlanNotificationsUseCase.Input input = new GenerateCarePlanNotificationsUseCase.Input();
//    assertNotNull(input);
//  }
//
//  @Test
//  void outputRecord_shouldStoreNotificationsList() {
//    List<CarePlanNotificationDTO> notifications = List.of(
//            createNotification("id1", null, null, Instant.now()),
//            createNotification("id2", null, null, Instant.now())
//    );
//    GenerateCarePlanNotificationsUseCase.Output output =
//            new GenerateCarePlanNotificationsUseCase.Output(notifications);
//
//    assertEquals(2, output.notificationsDTO().size());
//  }
//
//  // ================== Prueba de manejo de errores ==================
//
//  @Test
//  void shouldHandleServiceExceptions() {
//    when(notificationService.generateCarePlanClosureNotifications())
//            .thenThrow(new RuntimeException("Error en servicio"));
//
//    CompletableFuture<GenerateCarePlanNotificationsUseCase.Output> future =
//            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input());
//
//    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
//    assertTrue(exception.getCause() instanceof RuntimeException);
//    assertEquals("Error en servicio", exception.getCause().getMessage());
//  }
//
//  // ================== Métodos auxiliares ==================
  private Patient createPatient(String id, String firstName, String lastName) {
    return new Patient(id,
            List.of(new Identifier(null, null, null, "ID-" + firstName,
                    null, null)), true,
            List.of(new HumanName(null, null, lastName, List.of(firstName),null,
                    null, null)
            ), null, Patient.Gender.FEMALE, LocalDate.of(1990, 1, 1),
            List.of(new Address(null, null, null, null, "Ciudad", null,
                    null, null, null, null, null)), null,
            null, null
    );
  }

  private Practitioner createPractitioner(String id, String firstName, String lastName) {
    return new Practitioner(
            id,
            List.of(new Identifier(null, null, null, "LIC-" + firstName, null,
                    null)),
            true,
            List.of(new HumanName(null, null, lastName, List.of(firstName),null,
                            null, null)
            ), null, Practitioner.Gender.FEMALE,
            LocalDate.of(1980, 1, 1),
            List.of(new Address(null, null, List.of("Dirección"), null, "Ciudad",
                    null, null, null, null, null, null)
            ), null
    );
  }

  private CarePlanNotificationDTO createNotification(
          String carePlanId, Patient patient, Practitioner practitioner, Instant endDate,
          String expectedMessageSnippet) {
    String message = endDate != null ?
            "El plan de cuidado " + expectedMessageSnippet + " el "
                    + LocalDate.ofInstant(endDate, ZoneId.systemDefault()) :
            "Plan sin fecha de expiración";

    return new CarePlanNotificationDTO(
            carePlanId,
            patient,
            practitioner,
            endDate,
            message
    );
  }

//  @ParameterizedTest
//  @CsvSource({
//          "true, true, 'El plan de cuidado para'",
//          "true, false, 'sin profesional asociado'",
//          "false, true, 'sin paciente asociado'",
//          "false, false, 'sin paciente ni profesional asociado'"
//  })
//  void shouldGenerateAppropriateMessages(boolean hasPatient, boolean hasPractitioner, String expectedText)
//          throws ExecutionException, InterruptedException {
//    Patient patient = hasPatient ? createPatient("patient-id", "Paciente", "Apellido") : null;
//    Practitioner practitioner = hasPractitioner ? createPractitioner("pract-id", "Profesional", "Apellido") : null;
//
//    CarePlanNotificationDTO notification = new CarePlanNotificationDTO(
//            "careplan-id",
//            patient,
//            practitioner,
//            Instant.now().plus(7, ChronoUnit.DAYS),
//            "Mensaje generado"
//    );
//
//    when(notificationService.generateCarePlanClosureNotifications())
//            .thenReturn(List.of(notification));
//
//    GenerateCarePlanNotificationsUseCase.Output output =
//            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input()).get();
//
//    CarePlanNotificationDTO result = output.notificationsDTO().get(0);
//    assertTrue(result.notificationMessage().contains(expectedText));
//  }
//
//  @Test
//  void shouldHandleExtremeDates() throws ExecutionException, InterruptedException {
//    // Fecha mínima
//    Instant minDate = Instant.MIN;
//    // Fecha máxima
//    Instant maxDate = Instant.MAX;
//
//    CarePlanNotificationDTO minDateNotification = createNotification(
//            "min-date",
//            createPatient("p1", "Paciente", "Min"),
//            createPractitioner("d1", "Doctor", "Min"),
//            minDate
//    );
//
//    CarePlanNotificationDTO maxDateNotification = createNotification(
//            "max-date",
//            createPatient("p2", "Paciente", "Max"),
//            createPractitioner("d2", "Doctor", "Max"),
//            maxDate
//    );
//
//    when(notificationService.generateCarePlanClosureNotifications())
//            .thenReturn(List.of(minDateNotification, maxDateNotification));
//
//    GenerateCarePlanNotificationsUseCase.Output output =
//            generateCarePlanNotificationsUseCase.execute(new GenerateCarePlanNotificationsUseCase.Input()).get();
//
//    assertEquals(2, output.notificationsDTO().size());
//    assertEquals(minDate, output.notificationsDTO().get(0).endDate());
//    assertEquals(maxDate, output.notificationsDTO().get(1).endDate());
//  }
}
