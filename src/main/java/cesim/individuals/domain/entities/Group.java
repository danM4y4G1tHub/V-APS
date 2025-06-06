package cesim.individuals.domain.entities;

import java.util.List;

public record Group(
        String resourceType,
        String id,
        List<Identifier> identifier,
        Boolean active,
        Group.Type type,
        Group.Membership membership,
        CodeableConcept code,
        String name,
        String description,
        Integer quantity,
        Reference managingEntity,
        List<Group.Characteristic> characteristic,
        List<Group.Member> member
) {

  public enum Type {
    PERSON("person"),
    ANIMAL("animal"),
    PRACTITIONER("practitioner"),
    DEVICE("device"),
    CARETEAM("careteam"),
    HEALTHCARESERVICE("healthcareservice"),
    LOCATION("location"),
    ORGANIZATION("organization"),
    RELATEDPERSON("relatedperson"),
    SPECIMEN("specimen");

    private final String value;

    Type(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum Membership {
    DEFINITIONAL("definitional"),
    ENUMERATED("enumerated");

    private final String value;

    Membership(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public record Characteristic(
          CodeableConcept code,
          CodeableConcept valueCodeableConcept,
          Boolean valueBoolean,
          Quantity valueQuantity,
          Range valueRange,
          Reference valueReference,
          Boolean exclude,
          Period period
  ) {
  }

  public record Member(
          Reference entity,
          Period period,
          Boolean inactive
  ) {
  }
}
