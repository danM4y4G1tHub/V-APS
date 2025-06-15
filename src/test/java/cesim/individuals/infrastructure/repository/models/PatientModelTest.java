package cesim.individuals.infrastructure.repository.models;

import static org.junit.jupiter.api.Assertions.*;

import cesim.individuals.domain.entities.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

class PatientModelTest {
  private final ObjectMapper mapper;

  public PatientModelTest() {
    mapper = new ObjectMapper();
    // Registrar módulo para fechas de Java 8
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeJsonWithGeneralPractitionerArray() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"Patient\",\n" +
            "  \"id\": \"bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\",\n" +
            "  \"identifier\": [{\"system\": \"http://minsap.cu/ci\", \"value\": \"92020254321\"}],\n" +
            "  \"active\": true,\n" +
            "  \"name\": [{\"use\": \"official\", \"family\": \"Rodríguez\", \"given\": [\"María\", \"Elena\"]}],\n" +
            "  \"telecom\": [{\"system\": \"phone\", \"value\": \"+5355512345\", \"use\": \"work\"}],\n" +
            "  \"gender\": \"female\",\n" +
            "  \"birthDate\": \"1992-02-02\",\n" +
            "  \"address\": [{\n" +
            "    \"use\": \"home\",\n" +
            "    \"type\": \"both\",\n" +
            "    \"line\": [\"Calle 23 #456\"],\n" +
            "    \"city\": \"La Habana\",\n" +
            "    \"state\": \"La Habana\",\n" +
            "    \"postalCode\": \"10400\",\n" +
            "    \"country\": \"Cuba\",\n" +
            "    \"location\": {\"reference\": \"Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a\"}\n" +
            "  }],\n" +
            "  \"maritalStatus\": {\"coding\": [{\"code\": \"M\", \"display\": \"Casada\"}]},\n" +
            "  \"contact\": [{\n" +
            "    \"relationship\": [{\n" +
            "      \"coding\": [{\"system\": \"http://terminology.hl7.org/CodeSystem/v2-0131\",\"code\": \"C\"}]\n" +
            "    }],\n" +
            "    \"name\": {\"use\": \"usual\", \"family\": \"Vazques\", \"given\": [\"Juan Pablo\"]},\n" +
            "    \"telecom\": [{\"system\": \"phone\", \"value\": \"+5358337269\"}]\n" + // <-- Aquí se movió el telecom
            "  }],\n" +
            "  \"generalPractitioner\": [{\"reference\": \"Practitioner/12345678-1234-1234-1234-123456789abc\"}]\n" +
            "}";

    Patient patient = mapper.readValue(json, Patient.class);

    assertNotNull(patient);
    assertEquals("Patient", patient.resourceType());
    assertEquals("bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", patient.id());
    assertEquals(1, patient.generalPractitioner().size());
    assertEquals("Practitioner/12345678-1234-1234-1234-123456789abc", patient.generalPractitioner().get(0).reference());
  }
}
