package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Location(
        String resourceType,
        String id,
        List<Identifier> identifier,
        Location.Status status,
        Coding operationalStatus,
        String name,
        List<String> alias,
        String description,
        String mode,
        List<CodeableConcept> typeCode,
        List<ExtendedContactDetail> contact,
        Address address,
        CodeableConcept form,
        Position position,
        Reference managingOrganization,
        Reference partOf,
        List<CodeableConcept> characteristic,
        List<Availability> hoursOfOperation,
        List<VirtualServiceDetail> virtualService,
        List<Reference> endpoint
) {
  public enum Status{
    ACTIVE("active"),
    SUSPENDED("suspended"),
    INACTIVE("inactive");

    private final String value;

    Status(String value) { this.value = value;}

    @JsonValue
    public String getValue() { return value; }
  }

  public enum Mode {
    INSTANCE("instance"),
    KIND("kind");

    private final String value;

    Mode(String value){
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  record Position(
          BigDecimal longitude,
          BigDecimal latitude,
          BigDecimal altitude   // Altitude with WGS84 datum
  ) {}
}
