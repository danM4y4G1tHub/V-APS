package cesim.individuals.domain.entities;

import java.util.List;

public record Filter(
        String code,
        String description,
        List<Filter.Operator> operator,
        String value
) {
    public enum Operator{
        EQ("eq"),
        NE("ne"),
        GT("gt"),
        LT("lt"),
        GE("ge"),
        LE("le"),
        IN("in"),
        NOT_IN("not-in");

        private final String value;

        Operator(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
