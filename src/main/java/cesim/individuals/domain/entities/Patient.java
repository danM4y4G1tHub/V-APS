package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Patient(
        String resourceType,
        String id,
        List<Identifier> identifier,
        boolean active,
        List<HumanName> name,
        List<ContactPoint> telecom,
        Patient.Gender gender,
        LocalDate birthDate,
        Boolean deceasedBoolean,
        LocalDateTime deceasedDateTime,
        List<Address> address,
        CodeableConcept maritalStatus,
        Boolean multipleBirthBoolean,
        Integer multipleBirthInteger,
        List<Attachment> photo,
        List<Contact> contact,
        List<Communication> communication,
        List<Reference> generalPractitioner,
        Reference managingOrganization,
        List<Link> link) {

  public Patient(
          String id,
          List<Identifier> identifier,
          boolean active,
          List<HumanName> name,
          List<ContactPoint> telecom,
          Gender gender,
          LocalDate birthDate,
          List<Address> address,
          CodeableConcept maritalStatus,
          List<Contact> contact,
          List<Reference> generalPractitioner
  ){
    this(
            "Patient",
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
            maritalStatus,
            null,
            null,
            null,
            contact,
            null,
            generalPractitioner,
            null,
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
}
