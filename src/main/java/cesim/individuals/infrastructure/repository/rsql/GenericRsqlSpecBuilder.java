package cesim.individuals.infrastructure.repository.rsql;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.LogicalNode;
import cz.jirutka.rsql.parser.ast.LogicalOperator;
import cz.jirutka.rsql.parser.ast.Node;

public class GenericRsqlSpecBuilder<T>{

    public Specification<T> createSpecification(Node node) {
        if (node instanceof LogicalNode logicalNode) {
            return createSpecification(logicalNode);
        }
        if (node instanceof ComparisonNode comparisonNode) {
            return createSpecification(comparisonNode);
        }
        return null;
    }

    public Specification<T> createSpecification(LogicalNode logicalNode) {
        List<Specification<T>> specs = logicalNode.getChildren()
                .stream()
                .map(this::createSpecification).toList();

        Specification<T> result = specs.get(0);
        if (logicalNode.getOperator() == LogicalOperator.AND) {
            for (int i = 1; i < specs.size(); i++) {
                result = Specification.where(result).and(specs.get(i));
            }
        } else if (logicalNode.getOperator() == LogicalOperator.OR) {
            for (int i = 1; i < specs.size(); i++) {
                result = Specification.where(result).or(specs.get(i));
            }
        }

        return result;
    }

    public Specification<T> createSpecification(ComparisonNode comparisonNode) {
        return Specification.where(new GenericRsqlSpecification<T>(
                comparisonNode.getSelector(),
                comparisonNode.getOperator(),
                comparisonNode.getArguments()));
    }
}
