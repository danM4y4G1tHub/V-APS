package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Encounter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class EncounterModelTest {

  private final ObjectMapper mapper;

  public EncounterModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeJsonEncounter() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"Encounter\",\n" +
            "  \"id\": \"8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c\",\n" +
            "  \"status\": \"finished\",\n" +
            "  \"classfhir\": [\n" +
            "    {\n" +
            "      \"coding\": [\n" +
            "        {\n" +
            "          \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ActCode\",\n" +
            "          \"code\": \"AMB\",\n" +
            "          \"display\": \"Ambulatory\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"text\": \"Consulta ambulatoria\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"type\": [\n" +
            "    {\n" +
            "      \"coding\": [\n" +
            "        {\n" +
            "          \"system\": \"http://snomed.info/sct\",\n" +
            "          \"code\": \"185349003\",\n" +
            "          \"display\": \"Consulta de control\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"subject\": {\n" +
            "    \"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\"\n" +
            "  },\n" +
            "  \"actualPeriod\": {\n" +
            "    \"start\": \"2023-10-05T08:00:00Z\",\n" +
            "    \"end\": \"2023-10-05T08:30:00Z\"\n" +
            "  },\n" +
            "  \"participant\": [\n" +
            "    {\n" +
            "      \"type\": [\n" +
            "        {\n" +
            "          \"coding\": [\n" +
            "            {\n" +
            "              \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ParticipationType\",\n" +
            "              \"code\": \"PPRF\",\n" +
            "              \"display\": \"Intérprete principal\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"period\": {\n" +
            "        \"start\": \"2023-10-05T08:00:00Z\",\n" +
            "        \"end\": \"2023-10-05T08:30:00Z\"\n" +
            "      },\n" +
            "      \"actor\": {\n" +
            "        \"reference\": \"Practitioner/12345678-1234-1234-1234-123456789abc\",\n" +
            "        \"display\": \"Dra. Ana López\"\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"appointment\": [\n" +
            "    {\n" +
            "      \"reference\": \"Appointment/2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"reason\": [\n" +
            "    {\n" +
            "      \"use\": [\n" +
            "        {\n" +
            "          \"coding\": [\n" +
            "            {\n" +
            "              \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ActReason\",\n" +
            "              \"code\": \"PATPREF\",\n" +
            "              \"display\": \"Patient preference\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"text\": \"El paciente ha sufrido de una crisis diabética\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"value\": [\n" +
            "        {\n" +
            "          \"reference\": \"Condition/6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a\",\n" +
            "          \"display\": \"Crisis diabética\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"diagnosis\": [\n" +
            "    {\n" +
            "      \"condition\": [\n" +
            "        {\n" +
            "          \"reference\": \"Condition/6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"use\": [\n" +
            "        {\n" +
            "          \"coding\": [\n" +
            "            {\n" +
            "              \"system\": \"http://terminology.hl7.org/CodeSystem/diagnosis-role\",\n" +
            "              \"code\": \"AD\",\n" +
            "              \"display\": \"Admission diagnosis\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    Encounter encounter = mapper.readValue(json, Encounter.class);

    assertNotNull(encounter);
    assertEquals("Encounter", encounter.resourceType());
    assertEquals("8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c", encounter.id());
    assertEquals("finished", encounter.status().getValue());

    assertNotNull(encounter.classfhir());
    assertEquals(1, encounter.classfhir().size());
    assertEquals("AMB", encounter.classfhir().get(0).coding().get(0).code());
    assertEquals("Ambulatory", encounter.classfhir().get(0).coding().get(0).display());
    assertEquals("Consulta ambulatoria", encounter.classfhir().get(0).text());

    assertNotNull(encounter.type());
    assertEquals(1, encounter.type().size());
    assertEquals("Consulta de control", encounter.type().get(0).coding().get(0).display());

    assertNotNull(encounter.subject());
    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", encounter.subject().reference());

    assertNotNull(encounter.actualPeriod());
    assertEquals(Instant.parse("2023-10-05T08:00:00Z"), encounter.actualPeriod().start());
    assertEquals(Instant.parse("2023-10-05T08:30:00Z"), encounter.actualPeriod().end());

    assertNotNull(encounter.participant());
    assertEquals(1, encounter.participant().size());
    assertEquals("Intérprete principal", encounter.participant().get(0).type().get(0).coding().get(0).display());
    assertEquals("Dra. Ana López", encounter.participant().get(0).actor().display());

    assertNotNull(encounter.appointment());
    assertEquals(1, encounter.appointment().size());
    assertEquals("Appointment/2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e", encounter.appointment().get(0).reference());

    assertNotNull(encounter.reason());
    assertEquals(1, encounter.reason().size());

    assertEquals("El paciente ha sufrido de una crisis diabética", encounter.reason().get(0).use().get(0).text());
    assertEquals("Patient preference", encounter.reason().get(0).use().get(0).coding().get(0).display());

    assertNotNull(encounter.diagnosis());
    assertEquals(1, encounter.diagnosis().size());
    assertEquals("Condition/6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a", encounter.diagnosis().get(0).condition().get(0).reference());
    assertEquals("Admission diagnosis", encounter.diagnosis().get(0).use().get(0).coding().get(0).display());
  }
}
