package cesim.individuals.domain.entities;

public record Property(
        String code,
        String description,
        Property.Type type,
        String uri) {

    public enum Type {
        STRING("string"),
        INTEGER("integer"),
        DECIMAL("decimal"),
        BOOLEAN("boolean"),
        DATE("date"),
        DATETIME("datetime"),
        TIME("time"),
        URI("uri");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
