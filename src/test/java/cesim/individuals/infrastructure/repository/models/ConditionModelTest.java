package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Condition;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ConditionModelTest {

  private final ObjectMapper mapper;

  public ConditionModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeJsonCondition() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"Condition\",\n" +
            "  \"id\": \"6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a\",\n" +
            "  \"clinicalStatus\": {\n" +
            "    \"coding\": [{\n" +
            "      \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\",\n" +
            "      \"code\": \"active\"\n" +
            "    }]\n" +
            "  },\n" +
            "  \"code\": {\n" +
            "    \"coding\": [{\n" +
            "      \"system\": \"http://snomed.info/sct\",\n" +
            "      \"code\": \"44054006\",\n" +
            "      \"display\": \"Diabetes mellitus tipo 2\"\n" +
            "    }]\n" +
            "  },\n" +
            "  \"subject\": {\"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\"},\n" +
            "  \"encounter\": {\"reference\": \"Encounter/8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c\"},\n" +
            "  \"recordedDate\": \"2023-05-15T14:30:00Z\",\n" +
            "  \"participant\": [{\n" +
            "    \"function\": {\n" +
            "      \"coding\": [{\n" +
            "        \"system\": \"http://terminology.hl7.org/CodeSystem/provenance-participant-type\",\n" +
            "        \"code\": \"enterer\",\n" +
            "        \"display\": \"Enterer\"\n" +
            "      }]\n" +
            "    },\n" +
            "    \"actor\": {\"reference\": \"Practitioner/12345678-1234-1234-1234-123456789abc\"}\n" +
            "  }]\n" +
            "}";

    Condition condition = mapper.readValue(json, Condition.class);
    assertNotNull(condition);
    assertEquals("Condition", condition.resourceType());
    assertEquals("6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a", condition.id());
    assertNotNull(condition.clinicalStatus());
    assertEquals("active", condition.clinicalStatus().coding().get(0).code());
    assertNotNull(condition.code());
    assertEquals("Diabetes mellitus tipo 2", condition.code().coding().get(0).display());
    assertNotNull(condition.subject());
    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", condition.subject().reference());
    assertNotNull(condition.encounter());
    assertEquals("Encounter/8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c", condition.encounter().reference());
    assertNotNull(condition.recordedDate());

    LocalDateTime dateTime = LocalDateTime.parse("2023-05-15T14:30:00");
    assertEquals(dateTime, condition.recordedDate());

    assertNotNull(condition.participant());
    assertEquals(1, condition.participant().size());
    assertEquals("Enterer", condition.participant().get(0).function().coding().get(0).display());
    assertEquals("Practitioner/12345678-1234-1234-1234-123456789abc", condition.participant().get(0).actor().reference());
  }
}
