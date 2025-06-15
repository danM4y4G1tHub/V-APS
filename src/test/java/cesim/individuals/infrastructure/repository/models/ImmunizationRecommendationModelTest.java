package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Coding;
import cesim.individuals.domain.entities.ImmunizationRecommendation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ImmunizationRecommendationModelTest {

  private final ObjectMapper mapper;

  public ImmunizationRecommendationModelTest() {
    this.mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeJsonImmunizationRecommendation() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"ImmunizationRecommendation\",\n" +
            "  \"id\": \"1f8c4a2b-3b5d-4c6e-8e8d-1b2c3d4e5f6a\",\n" +
            "  \"patient\": {\n" +
            "    \"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\"\n" +
            "  },\n" +
            "  \"recommendation\": [{\n" +
            "    \"vaccineCode\": {\n" +
            "      \"coding\": [{\n" +
            "        \"system\": \"http://hl7.org/fhir/sid/cvx\",\n" +
            "        \"code\": \"08\",\n" +
            "        \"display\": \"Hepatitis B\"\n" +
            "      }]\n" +
            "    },\n" +
            "    \"forecastStatus\": {\n" +
            "      \"coding\": [{\n" +
            "        \"system\": \"http://terminology.hl7.org/CodeSystem/immunization-recommendation-status\",\n" +
            "        \"code\": \"due\",\n" +
            "        \"display\": \"Dose is due\"\n" +
            "      }]\n" +
            "    },\n" +
            "    \"dateCriterion\": [{\n" +
            "      \"code\": {\n" +
            "        \"coding\": [{\n" +
            "          \"system\": \"http://loinc.org\",\n" +
            "          \"code\": \"30980-7\",\n" +
            "          \"display\": \"Earliest Date\"\n" +
            "        }]\n" +
            "      },\n" +
            "      \"value\": \"2025-07-01T00:00:00\"\n" +
            "    }],\n" +
            "    \"doseNumber\":" + 3 +
            "  }]\n" +
            "}";

    ImmunizationRecommendation rec = mapper.readValue(json, ImmunizationRecommendation.class);

    // Validaciones básicas
    assertNotNull(rec);
    assertEquals("ImmunizationRecommendation", rec.resourceType());
    assertEquals("1f8c4a2b-3b5d-4c6e-8e8d-1b2c3d4e5f6a", rec.id());

    // Validación de paciente
    assertNotNull(rec.patient());
    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", rec.patient().reference());

    // Validación de recomendaciones
    assertNotNull(rec.recommendation());
    assertEquals(1, rec.recommendation().size());

    ImmunizationRecommendation.Recommendation recommendation = rec.recommendation().get(0);

    // VaccineCode
    assertNotNull(recommendation.vaccineCode());
    Coding vaccineCoding = recommendation.vaccineCode().coding().get(0);
    assertEquals("http://hl7.org/fhir/sid/cvx", vaccineCoding.system());
    assertEquals("08", vaccineCoding.code());
    assertEquals("Hepatitis B", vaccineCoding.display());

    // ForecastStatus
    assertNotNull(recommendation.forecastStatus());
    Coding statusCoding = recommendation.forecastStatus().coding().get(0);
    assertEquals("http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", statusCoding.system());
    assertEquals("due", statusCoding.code());
    assertEquals("Dose is due", statusCoding.display());

    // DateCriterion
    assertNotNull(recommendation.dateCriterion());
    assertEquals(1, recommendation.dateCriterion().size());
    ImmunizationRecommendation.Recommendation.DateCriterion dateCriterion = recommendation.dateCriterion().get(0);
    Coding dateCoding = dateCriterion.code().coding().get(0);
    assertEquals("http://loinc.org", dateCoding.system());
    assertEquals("30980-7", dateCoding.code());
    assertEquals("Earliest Date", dateCoding.display());
    assertEquals(LocalDateTime.parse("2025-07-01T00:00:00"), dateCriterion.value());

    // DoseNumber
    assertEquals(3, recommendation.doseNumber());
  }
}
