package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.util.List;

public record RelatedPerson(
        String resourceType,
        String id,
        List<Identifier> identifier,
        boolean active,
        Reference patient,
        List<CodeableConcept> relationship,
        List<HumanName> name,
        List<ContactPoint> telecom,
        RelatedPerson.Gender gender,
        LocalDate birthDate,
        List<Address> address,
        List<Attachment> photo,
        Period period,
        List<Communication> communication) {
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
