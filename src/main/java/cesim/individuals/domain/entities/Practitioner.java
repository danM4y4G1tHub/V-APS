package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Practitioner(
        String resourceType,
        String id,
        List<Identifier> identifier,
        boolean active,
        List<HumanName> name,
        List<ContactPoint> telecom,
        Practitioner.Gender gender,
        LocalDate birthDate,
        Boolean deceasedBoolean,
        LocalDateTime deceasedDateTime,
        List<Address> address,
        List<Attachment> photo,
        List<Qualification> qualification,
        List<Communication> communication
) {
  public Practitioner(
          String id,
          List<Identifier> identifier,
          boolean active,
          List<HumanName> name,
          List<ContactPoint> telecom,
          Practitioner.Gender gender,
          LocalDate birthDate,
          List<Address> address,
          List<Qualification> qualification
  ){
    this(
            "Practitioner",
            id,
            identifier,
            active,
            name,
            telecom,
            gender,
            birthDate,
            null,
            null,
            address,
            null,
            qualification,
            null
    );
  }

  public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHER("other"),
    UNKNOWN("unknown");

    private final String value;

    Gender(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public record Qualification(
          List<Identifier> identifier,
          CodeableConcept code,
          Period period,
          Reference issuer
  ) {
  }
}
