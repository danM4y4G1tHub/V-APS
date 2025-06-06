package cesim.individuals.domain.entities;

import java.util.List;

public record Endpoint(
                List<Identifier> identifier,
                Endpoint.Status status,
                String description,
                String name,
                List<CodeableConcept> connectionType,
                List<CodeableConcept> environmentType,
                Reference managingOrganization,
                List<ContactPoint> contact,
                Period period,
                List<PayloadType> payload,
                String address,
                List<String> header) {
        public enum Status {
                ACTIVE("active"),
                DRAFT("draft"),
                RETIRED("retired"),
                UNKNOWN("unknown");

                private final String value;

                Status(String value) {
                        this.value = value;
                }

                public String getValue() {
                        return value;
                }
        }
}
