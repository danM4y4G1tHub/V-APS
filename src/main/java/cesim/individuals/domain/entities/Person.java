package cesim.individuals.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record Person(
                String resourceType,
                List<Identifier> identifier,
                boolean active,
                List<HumanName> name,
                List<ContactPoint> telecom,
                String gender,
                LocalDate birthDate,
                Boolean deceasedBoolean,
                LocalDateTime deceasedDateTime,
                List<Address> address,
                CodeableConcept maritalStatus,
                List<Attachment> photo,
                List<Communication> communication,
                Reference managingOrganization,
                List<Person.Link> link) {
        public record Link(
                        Reference target,
                        Link.Assurance assurance) {
                public enum Assurance {
                        LEVEL1("level1"),
                        LEVEL2("level2"),
                        LEVEL3("level3"),
                        LEVEL4("level4");

                        private final String value;

                        Assurance(String value) {
                                this.value = value;
                        }

                        public String getValue() {
                                return value;
                        }
                }
        }
}
