package cesim.individuals.domain.entities;

public record Quantity<T extends Number>(
        T value,
        Quantity.Comparator comparator,
        String unit,
        String system,
        String code) {
    public enum Comparator {
        EQUALS("equals"),
        GREATER_THAN("greaterThan"),
        GREATER_THAN_OR_EQUALS("greaterThanOrEquals"),
        LESS_THAN("lessThan"),
        LESS_THAN_OR_EQUALS("lessThanOrEquals");

        private final String value;

        Comparator(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
