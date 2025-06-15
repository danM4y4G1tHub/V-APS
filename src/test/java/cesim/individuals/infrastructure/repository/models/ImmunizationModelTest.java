package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Immunization;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ImmunizationModelTest {

  private final ObjectMapper mapper;

  public ImmunizationModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeJsonImmunization() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"Immunization\",\n" +
            "  \"id\": \"5a6b7c8d-9e0f-1a2b-3c4d-5e6f7a8b9c0d\",\n" +
            "  \"status\": \"completed\",\n" +
            "  \"vaccineCode\": {\n" +
            "    \"coding\": [\n" +
            "      {\n" +
            "        \"system\": \"http://hl7.org/fhir/sid/cvx\",\n" +
            "        \"code\": \"207\",\n" +
            "        \"display\": \"COVID-19, Abdala\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"patient\": {\n" +
            "    \"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\"\n" +
            "  },\n" +
            "  \"occurrenceDateTime\": \"2021-08-15T10:00:00Z\"\n" +
            "}";
    Immunization immunization = mapper.readValue(json, Immunization.class);
    assertNotNull(immunization);
    assertEquals("Immunization", immunization.resourceType());
    assertEquals("5a6b7c8d-9e0f-1a2b-3c4d-5e6f7a8b9c0d", immunization.id());
    assertEquals("completed", immunization.status().getValue());
    assertNotNull(immunization.vaccineCode());
    assertEquals("207", immunization.vaccineCode().coding().get(0).code());
    assertEquals("COVID-19, Abdala", immunization.vaccineCode().coding().get(0).display());
    assertNotNull(immunization.patient());
    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", immunization.patient().reference());
    assertNotNull(immunization.occurrenceDateTime());
    assertEquals(LocalDateTime.parse("2021-08-15T10:00:00"), immunization.occurrenceDateTime());
  }
}
