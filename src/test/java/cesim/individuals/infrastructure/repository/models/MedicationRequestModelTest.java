package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.MedicationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MedicationRequestModelTest {

  private final ObjectMapper mapper;

  public MedicationRequestModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeMedicationRequestFromJson() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"MedicationRequest\",\n" +
            "  \"id\": \"b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e\",\n" +
            "  \"status\": \"active\",\n" +
            "  \"intent\": \"order\",\n" +
            "  \"medication\": {\n" +
            "    \"reference\": \"Medication/insulina-rdna\",\n" +
            "    \"display\": \"Insulina Recombinante Humana (rDNA)\"\n" +
            "  },\n" +
            "  \"subject\": {\n" +
            "    \"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\"\n" +
            "  },\n" +
            "  \"requester\": {\n" +
            "    \"reference\": \"Practitioner/12345678-1234-1234-1234-123456789abc\",\n" +
            "    \"display\": \"Dr. José Ramírez\"\n" +
            "  },\n" +
            "  \"reason\": [\n" +
            "    {\n" +
            "      \"reference\": \"Condition/diabetes-tipo2\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"dosageInstruction\": [\n" +
            "    {\n" +
            "      \"text\": \"Aplicar 10 unidades subcutáneas antes del desayuno diariamente\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"renderedDosageInstruction\": \"Aplicar 10 unidades subcutáneas antes del desayuno diariamente\",\n" +
            "  \"authoredOn\": \"2023-10-12T10:00:00\"\n" +
            "}";

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());

    MedicationRequest medicationRequest = mapper.readValue(json, MedicationRequest.class);

    assertNotNull(medicationRequest);
    assertEquals("MedicationRequest", medicationRequest.resourceType());
    assertEquals("b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e", medicationRequest.id());
    assertEquals(MedicationRequest.Status.ACTIVE, medicationRequest.status());
    assertEquals(MedicationRequest.Intent.ORDER, medicationRequest.intent());
    assertEquals("Medication/insulina-rdna", medicationRequest.medication().reference());
    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            medicationRequest.subject().reference());
    assertEquals("Practitioner/12345678-1234-1234-1234-123456789abc",
            medicationRequest.requester().reference());
    assertEquals("Condition/diabetes-tipo2", medicationRequest.reason().get(0).reference());
    assertEquals("Aplicar 10 unidades subcutáneas antes del desayuno diariamente",
            medicationRequest.dosageInstruction().get(0).text());
    assertEquals("Aplicar 10 unidades subcutáneas antes del desayuno diariamente",
            medicationRequest.renderedDosageInstruction());
    assertEquals(LocalDateTime.of(2023, 10, 12, 10, 0), medicationRequest.authoredOn());
  }
}
