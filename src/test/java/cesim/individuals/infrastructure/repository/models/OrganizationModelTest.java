package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Organization;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationModelTest {

  private final ObjectMapper mapper;

  public OrganizationModelTest() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void testDeserializeJsonOrganization() throws Exception {
    String json = "{\n" +
            "  \"resourceType\": \"Organization\",\n" +
            "  \"id\": \"0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a\",\n" +
            "  \"name\": \"Centro de Ingeniería Genética y Biotecnología\",\n" +
            "  \"contact\": [\n" +
            "    {\n" +
            "      \"address\": {\n" +
            "        \"line\": [\"Ave. 31 entre 158 y 190\"],\n" +
            "        \"city\": \"La Habana\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    Organization organization = mapper.readValue(json, Organization.class);
    assertNotNull(organization);
    assertEquals("Organization", organization.resourceType());
    assertEquals("0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a", organization.id());
    assertEquals("Centro de Ingeniería Genética y Biotecnología", organization.name());
    assertNotNull(organization.contact());
    assertEquals(1, organization.contact().size());
    assertEquals("Ave. 31 entre 158 y 190", organization.contact().get(0).address().line().get(0));
    assertEquals("La Habana", organization.contact().get(0).address().city());
  }
}
