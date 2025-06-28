package cesim.individuals.entity;

import cesim.individuals.domain.entities.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

  @Test
  void patientShouldMapFhirFieldsCorrectly() {
    Instant startDate = Instant.parse("2023-10-05T08:00:00Z");
    Instant endDate = Instant.parse("2023-10-05T08:30:00Z");

    // Identifier
    Identifier identifier = new Identifier(
            Identifier.Use.OFFICIAL,
            new CodeableConcept(null, "CI"),
            "http://minsap.cu/ci",
            "85010112345",
            new Period(startDate, endDate),
            null
    );

    // HumanName
    HumanName name = new HumanName(
            HumanName.Use.OFFICIAL,
            "Carlos García",
            "García",
            List.of("Carlos"),
            List.of("Sr."),
            List.of(),
            new Period(startDate, endDate)
    );

    // ContactPoint
    ContactPoint telecom = new ContactPoint(
            ContactPoint.System.PHONE,
            "+5355512345",
            ContactPoint.Use.HOME,
            null,
            new Period(startDate, endDate)
    );

    // Address
    Address address = new Address(
            Address.Type.BOTH,
            Address.Use.HOME,
            List.of("Calle 23 #456"),
            new Period(startDate, endDate),
            "La Habana",
            "Cuba",
            "Plaza",
            "10400",
            "La Habana",
            "Calle 23 #456, Plaza, La Habana, Cuba",
            null
    );

    // Crear paciente
    Patient patient = new Patient(
            "Patient",
            "pat-123",
            List.of(identifier),
            true,
            List.of(name),
            List.of(telecom),
            Patient.Gender.MALE,
            LocalDate.of(1985, 1, 1),
            false,
            null,
            List.of(address),
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    );

    // Validaciones
    assertEquals("85010112345", patient.identifier().get(0).value());
    assertEquals("García", patient.name().get(0).family());
    assertEquals(Patient.Gender.MALE, patient.gender());
  }

  @Test
  void shouldAllowNullOptionalFields() {
    Patient patient = new Patient(
            "Patient",
            "pat-001",
            null, // identifier
            true,
            null, // name
            null, // telecom
            Patient.Gender.UNKNOWN,
            null, // birthDate
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    );

    assertNull(patient.birthDate());
    assertNull(patient.identifier());
    assertEquals(Patient.Gender.UNKNOWN, patient.gender());
  }

  @Test
  void shouldSupportMultipleIdentifiers() {
    Identifier id1 = new Identifier(Identifier.Use.USUAL, null, "sys1", "123", null, null);
    Identifier id2 = new Identifier(Identifier.Use.SECONDARY, null, "sys2", "456", null, null);

    Patient patient = new Patient(
            "Patient",
            "pat-002",
            List.of(id1, id2),
            true,
            null,
            null,
            Patient.Gender.FEMALE,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    );

    assertEquals(2, patient.identifier().size());
    assertEquals("456", patient.identifier().get(1).value());
  }

  @Test
  void patientsWithSameDataShouldBeEqual() {
    Identifier id = new Identifier(Identifier.Use.OFFICIAL, null, "sys", "id", null, null);

    Patient patient1 = new Patient(
            "Patient", "pat-003", List.of(id), true, null, null,
            Patient.Gender.OTHER, null, null, null,
            null, null, null, null, null, null, null, null, null, null
    );

    Patient patient2 = new Patient(
            "Patient", "pat-003", List.of(id), true, null, null,
            Patient.Gender.OTHER, null, null, null,
            null, null, null, null, null, null, null, null, null, null
    );

    assertEquals(patient1, patient2);
  }

  @Test
  void shouldAllowFutureBirthDateButLogicallyItMayBeInvalid() {
    LocalDate futureDate = LocalDate.now().plusYears(1);

    Patient patient = new Patient(
            "Patient",
            "pat-004",
            null,
            true,
            null,
            null,
            Patient.Gender.MALE,
            futureDate,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    );

    assertTrue(patient.birthDate().isAfter(LocalDate.now()));
  }

  @Test
  void shouldSupportPartialNestedObjects() {
    Identifier id = new Identifier(Identifier.Use.TEMP, null, null, "temp-id", null, null);

    Patient patient = new Patient(
            "Patient",
            "pat-005",
            List.of(id),
            true,
            null,
            null,
            Patient.Gender.UNKNOWN,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    );

    assertEquals("temp-id", patient.identifier().get(0).value());
    assertNull(patient.identifier().get(0).system());
  }

  @Test
  void shouldSerializePatientToJson() throws Exception {
    // Configuración del ObjectMapper para fechas en formato ISO-8601
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // ISO-8601

    Identifier identifier = new Identifier(
            Identifier.Use.OFFICIAL, null,
            "http://example.com", "123456789",
            null, null
    );

    Patient patient = new Patient(
            "Patient",
            "pat-json",
            List.of(identifier),
            true,
            null,
            null,
            Patient.Gender.FEMALE,
            LocalDate.of(1990, 5, 20),
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    );

    String json = mapper.writeValueAsString(patient);

    // Validaciones básicas de estructura y campos clave
    assertTrue(json.contains("\"id\":\"pat-json\""));
    assertTrue(json.contains("\"gender\":\"female\""));
    assertTrue(json.contains("\"birthDate\":\"1990-05-20\"")); // Verificación de ISO-8601
  }

  @Test
  void shouldDeserializeJsonToPatient() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // no es estrictamente necesario en deserialización, pero mantiene consistencia

    String json = """
    {
      "resourceType": "Patient",
      "id": "pat-json-2",
      "identifier": [
        {
          "use": "official",
          "system": "http://example.com",
          "value": "987654321"
        }
      ],
      "active": true,
      "gender": "male",
      "birthDate": "1980-10-10"
    }
    """;

    Patient patient = mapper.readValue(json, Patient.class);

    assertEquals("pat-json-2", patient.id());
    assertEquals("987654321", patient.identifier().get(0).value());
    assertEquals(Patient.Gender.MALE, patient.gender());
    assertEquals(LocalDate.of(1980, 10, 10), patient.birthDate()); // valida también la fecha
  }

  @Test
  void shouldFailValidationIfBirthDateIsInFuture() {
    Patient patient = new Patient(
            "Patient", "pat-rule-1", null,
            true, null, null,
            Patient.Gender.MALE, LocalDate.now().plusDays(1),
            null, null, null,
            null, null, null, null,
            null, null, null, null, null
    );

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      PatientValidator.validate(patient);
    });

    assertEquals("Birth date cannot be in the future.", exception.getMessage());
  }

  @Test
  void shouldFailValidationIfDeceasedWithoutDate() {
    Patient patient = new Patient(
            "Patient", "pat-rule-2", null,
            true, null, null,
            Patient.Gender.FEMALE, LocalDate.of(1960, 6, 6),
            true, null,
            null, null, null, null,
            null, null, null, null,
            null, null
    );

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      PatientValidator.validate(patient);
    });

    assertEquals("Deceased patients must have a date of death.", exception.getMessage());
  }
}
