package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Observation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ObservationModelTest {

  private final ObjectMapper mapper;

  public ObservationModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void shouldDeserializeObservationCorrectly() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"Observation\",\n" +
            "  \"id\": \"obs-clin-001\",\n" +
            "  \"status\": \"final\",\n" +
            "  \"code\": {\n" +
            "    \"coding\": [\n" +
            "      {\n" +
            "        \"system\": \"http://loinc.org\",\n" +
            "        \"code\": \"15074-8\",\n" +
            "        \"display\": \"Glucosa en sangre\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"subject\": {\n" +
            "    \"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\"\n" +
            "  },\n" +
            "  \"effectiveDateTime\": \"2023-10-05T08:30:00\",\n" +
            "  \"valueQuantity\": {\n" +
            "    \"value\": 5.6,\n" +
            "    \"unit\": \"mmol/L\"\n" +
            "  }\n" +
            "}";

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());

    Observation observation = mapper.readValue(json, Observation.class);

    assertNotNull(observation);
    assertEquals("Observation", observation.resourceType());
    assertEquals("obs-clin-001", observation.id());
    assertEquals(Observation.Status.FINAL, observation.status());

    assertNotNull(observation.code());
    assertEquals(1, observation.code().coding().size());
    assertEquals("http://loinc.org", observation.code().coding().get(0).system());
    assertEquals("15074-8", observation.code().coding().get(0).code());
    assertEquals("Glucosa en sangre", observation.code().coding().get(0).display());

    assertNotNull(observation.subject());
    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", observation.subject().reference());

    assertEquals(LocalDateTime.of(2023, 10, 5, 8, 30), observation.effectiveDateTime());

    assertNotNull(observation.valueQuantity());
    assertEquals(5.6, observation.valueQuantity().value());
    assertEquals("mmol/L", observation.valueQuantity().unit());
  }

  @Test
  void shouldDeserializeCommunityObservationCorrectly() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"Observation\",\n" +
            "  \"id\": \"obs-com-001\",\n" +
            "  \"status\": \"final\",\n" +
            "  \"context\": {\n" +
            "    \"reference\": \"Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a\"\n" +
            "  },\n" +
            "  \"code\": {\n" +
            "    \"coding\": [\n" +
            "      {\n" +
            "        \"code\": \"cleanliness-score\",\n" +
            "        \"display\": \"Cleanliness Score\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"valueQuantity\": {\n" +
            "    \"value\": 8,\n" +
            "    \"unit\": \"score\"\n" +
            "  }\n" +
            "}";

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());

    Observation observation = mapper.readValue(json, Observation.class);

    assertNotNull(observation);
    assertEquals("Observation", observation.resourceType());
    assertEquals("obs-com-001", observation.id());
    assertEquals(Observation.Status.FINAL, observation.status());

    assertNotNull(observation.context());
    assertEquals("Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a", observation.context().reference());

    assertNotNull(observation.code());
    assertEquals(1, observation.code().coding().size());
    assertEquals("cleanliness-score", observation.code().coding().get(0).code());
    assertEquals("Cleanliness Score", observation.code().coding().get(0).display());

    assertNotNull(observation.valueQuantity());
    assertEquals(8, observation.valueQuantity().value());
    assertEquals("score", observation.valueQuantity().unit());
  }
}
