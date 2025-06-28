package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Appointment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentModelTest {

  private final ObjectMapper mapper;

  public AppointmentModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeJsonAppointment() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"Appointment\",\n" +
            "  \"id\": \"2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\n" +
            "  \"status\": \"booked\",\n" +
            "  \"start\": \"2025-06-20T09:00:00Z\",\n" +
            "  \"participant\": [{\n" +
            "    \"type\": [{\n" +
            "      \"coding\": [{\n" +
            "        \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ParticipationType\",\n" +
            "        \"code\": \"PPRF\",\n" +
            "        \"display\": \"Intérprete principal\"\n" +
            "      }]\n" +
            "    }],\n" +
            "    \"period\": {\"start\": \"2025-06-20T09:00:00Z\", \"end\": \"2025-06-20T09:30:00Z\"},\n" +
            "    \"actor\": {\"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\", \"display\": \"María Elena\"},\n" +
            "    \"required\": true,\n" +
            "    \"status\": \"accepted\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"type\": [{\n" +
            "      \"coding\": [{\n" +
            "        \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ParticipationType\",\n" +
            "        \"code\": \"PRF\",\n" +
            "        \"display\": \"Profesional\"\n" +
            "      }]\n" +
            "    }],\n" +
            "    \"period\": {\"start\": \"2025-06-20T09:00:00Z\", \"end\": \"2025-06-20T09:30:00Z\"},\n" +
            "    \"actor\": {\n" +
            "      \"reference\": \"Practitioner/12345678-1234-1234-1234-123456789abc\",\n" +
            "      \"display\": \"Dra. Ana López\"\n" +
            "    },\n" +
            "    \"required\": true,\n" +
            "    \"status\": \"accepted\"\n" +
            "  }],\n" +
            "  \"description\": \"Consulta de control de diabetes\"\n" +
            "}";

    Appointment appointment = mapper.readValue(json, Appointment.class);
    assertNotNull(appointment);
    assertEquals("Appointment", appointment.resourceType());
    assertEquals("2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e", appointment.id());
    assertEquals(Appointment.Status.BOOKED.getValue(), appointment.status().getValue());
    assertEquals("Consulta de control de diabetes", appointment.description());
    assertNotNull(appointment.participant());
    assertEquals(2, appointment.participant().size());
    assertEquals("Intérprete principal", appointment.participant().get(0).type().get(0).coding().get(0).display());
    assertEquals("Dra. Ana López", appointment.participant().get(1).actor().display());
    assertEquals(Appointment.Participant.Status.ACCEPTED.getValue(), appointment.participant().get(0).status().getValue());
  }
}
