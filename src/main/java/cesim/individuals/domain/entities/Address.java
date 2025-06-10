package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Address(
        Address.Type type,
        Address.Use use,
        List<String> line,
        Period period,
        String city,
        String country,
        String district,
        String postalCode,
        String state,
        String text,
        Reference location
) {

    public enum Type {
        POSTAL("postal"),
        PHYSICAL("physical"),
        BOTH("both");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }
    }

    public enum Use {
        HOME("home"),
        WORK("work"),
        TEMP("temp"),
        OLD("old"),
        BILLING("billing");

        private final String value;
        Use(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }
    }
}
