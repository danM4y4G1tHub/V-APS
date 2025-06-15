package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.CarePlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CarePlanModelTest {

  private final ObjectMapper mapper;

  public CarePlanModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void shouldDeserializeCarePlanCorrectly() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"CarePlan\",\n" +
            "  \"id\": \"2d3e4f5a-6b7c-8d9e-0f1a-2b3c4d5e6f7a\",\n" +
            "  \"status\": \"active\",\n" +
            "  \"intent\": \"plan\",\n" +
            "  \"title\": \"Plan de cuidado para diabetes\",\n" +
            "  \"description\": \"Incluye monitoreo de glucosa y visitas regulares.\",\n" +
            "  \"created\": \"2023-09-15T10:00:00\",\n" +
            "  \"subject\": {\n" +
            "    \"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\"\n" +
            "  },\n" +
            "  \"period\": {\n" +
            "    \"start\": \"2023-10-01T00:00:00Z\",\n" +
            "    \"end\": \"2024-10-01T00:00:00Z\"\n" +
            "  },\n" +
            "  \"activity\": [\n" +
            "    {\n" +
            "      \"performedActivity\": [\n" +
            "        {\"reference\": \"Procedure/monitoring-glucose\"}\n" +
            "      ],\n" +
            "      \"progress\": [\n" +
            "        {\"text\": \"Paciente ha seguido el plan sin interrupciones.\"}\n" +
            "      ],\n" +
            "      \"plannedActivityReference\": {\n" +
            "        \"reference\": \"ServiceRequest/regular-checkup\"\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"note\": [\n" +
            "    {\"text\": \"El paciente ha sido informado del plan.\"}\n" +
            "  ]\n" +
            "}";

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());

    CarePlan carePlan = mapper.readValue(json, CarePlan.class);

    assertNotNull(carePlan);
    assertEquals("CarePlan", carePlan.resourceType());
    assertEquals("2d3e4f5a-6b7c-8d9e-0f1a-2b3c4d5e6f7a", carePlan.id());
    assertEquals(CarePlan.Status.ACTIVE, carePlan.status());
    assertEquals(CarePlan.Intent.PLAN, carePlan.intent());
    assertEquals("Plan de cuidado para diabetes", carePlan.title());
    assertEquals("Incluye monitoreo de glucosa y visitas regulares.", carePlan.description());
    assertEquals(LocalDateTime.of(2023, 9, 15, 10, 0), carePlan.created());

    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", carePlan.subject().reference());
    assertNotNull(carePlan.period());
    assertEquals(Instant.parse("2023-10-01T00:00:00Z"), carePlan.period().start());
    assertEquals(Instant.parse("2024-10-01T00:00:00Z"), carePlan.period().end());

    assertNotNull(carePlan.activity());
    assertEquals("Procedure/monitoring-glucose", carePlan.activity().get(0).performedActivity().get(0).reference());
    assertEquals("Paciente ha seguido el plan sin interrupciones.", carePlan.activity().get(0).progress().get(0).text());
    assertEquals("ServiceRequest/regular-checkup", carePlan.activity().get(0).plannedActivityReference().reference());
    assertEquals("El paciente ha sido informado del plan.", carePlan.note().get(0).text());
  }

}
