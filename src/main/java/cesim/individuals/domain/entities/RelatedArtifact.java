package cesim.individuals.domain.entities;

import java.util.Date;
import java.util.List;

public record RelatedArtifact(
        RelatedArtifact.Type type,
        String label,
        String display,
        List<CodeableConcept> classifier,
        String citation,
        Attachment document,
        String resource,
        Reference resourceReference,
        RelatedArtifact.Status publicationStatus,
        Date publicationDate) {

    public enum Type {
        DOCUMENTATION("documentation"),
        JUSTIFICATION("justification"),
        CITATION("citation"),
        PREDECESSOR("predecessor"),
        SUCCESSOR("successor"),
        DERIVED_FROM("derived_from"),
        DEPENDS_ON("depends_on"),
        COMPOSED_OF("composed_of");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Status {
        DRAFT("draft"),
        ACTIVE("active"),
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
