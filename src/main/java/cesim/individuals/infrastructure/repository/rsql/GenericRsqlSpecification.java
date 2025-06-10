package cesim.individuals.infrastructure.repository.rsql;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;

public class GenericRsqlSpecification<T> implements Specification<T> {

    private static final long serialVersionUID = 1L;
    private String property;
    private transient ComparisonOperator operator;
    private List<String> arguments;

    public GenericRsqlSpecification(String property, ComparisonOperator operator, List<String> arguments) {
        this.property = property;
        this.operator = operator;
        this.arguments = arguments;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<T> root, @NonNull CriteriaQuery<?> query, @NonNull CriteriaBuilder builder) {
        List<Object> args = castArguments(root);
        Object argument = args.get(0);

        switch (RsqlSearchOperation.getSimpleOperator(operator)) {
            case EQUAL: {
                if (argument instanceof String) {
                    return builder.like(root.get(property), argument.toString().replace('*', '%'));
                } else if (argument == null) {
                    return builder.isNull(root.get(property));
                } else {
                    return builder.equal(root.get(property), argument);
                }
            }
            case NOT_EQUAL: {
                if (argument instanceof String) {
                    return builder.notLike(root.get(property), argument.toString().replace('*', '%'));
                } else if (argument == null) {
                    return builder.isNotNull(root.get(property));
                } else {
                    return builder.notEqual(root.get(property), argument);
                }
            }
            case GREATER_THAN: {
                return builder.greaterThan(root.get(property), argument.toString());
            }
            case GREATER_THAN_OR_EQUAL: {
                return builder.greaterThanOrEqualTo(root.get(property), argument.toString());
            }
            case LESS_THAN: {
                return builder.lessThan(root.get(property), argument.toString());
            }
            case LESS_THAN_OR_EQUAL: {
                return builder.lessThanOrEqualTo(root.get(property), argument.toString());
            }
            case IN:
                return root.get(property).in(args);
            case NOT_IN:
                return builder.not(root.get(property).in(args));
        }

        return null;
    }

    private List<Object> castArguments(Root<T> root) {
        Class<?> type = root.get(property).getJavaType();
        return arguments.stream().map(arg -> {
            if (type.equals(Integer.class)) return Integer.parseInt(arg);
            if (type.equals(Long.class)) return Long.parseLong(arg);
            if (type.equals(Boolean.class)) return Boolean.parseBoolean(arg);
            return arg;
        }).collect(java.util.stream.Collectors.toList());
    }
}
