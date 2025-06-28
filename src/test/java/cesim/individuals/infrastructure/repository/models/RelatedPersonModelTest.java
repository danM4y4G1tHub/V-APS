package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.ContactPoint;
import cesim.individuals.domain.entities.RelatedPerson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelatedPersonModelTest {
  private final ObjectMapper mapper;

  public RelatedPersonModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeJsonRelatedPerson() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"RelatedPerson\",\n" +
            "  \"id\": \"4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a\",\n" +
            "  \"patient\": {\"reference\": \"Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a\"},\n" +
            "  \"relationship\": [{\"coding\": [{\"system\": \"http://terminology.hl7.org/CodeSystem/v3-RoleCode\", \"code\": \"H\", \"display\": \"Hija\"}]}],\n" +
            "  \"name\": [{\"family\": \"Rodríguez\", \"given\": [\"Laura\"]}],\n" +
            "  \"telecom\": [{\"system\": \"phone\", \"value\": \"+5355511111\"}]\n" +
            "}";

    RelatedPerson relatedPerson = mapper.readValue(json, RelatedPerson.class);

    assertNotNull(relatedPerson);
    assertEquals("RelatedPerson", relatedPerson.resourceType());
    assertEquals("4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a", relatedPerson.id());
    assertNotNull(relatedPerson.patient());
    assertEquals("Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", relatedPerson.patient().reference());
    assertNotNull(relatedPerson.relationship());
    assertEquals(1, relatedPerson.relationship().size());
    assertEquals("Hija", relatedPerson.relationship().get(0).coding().get(0).display());
    assertNotNull(relatedPerson.name());
    assertEquals(1, relatedPerson.name().size());
    assertEquals("Rodríguez", relatedPerson.name().get(0).family());
    assertEquals("Laura", relatedPerson.name().get(0).given().get(0));
    assertNotNull(relatedPerson.telecom());
    assertEquals(1, relatedPerson.telecom().size());
    assertEquals("phone", relatedPerson.telecom().get(0).system().getValue());
    assertEquals("+5355511111", relatedPerson.telecom().get(0).value());
  }
}
