package cesim.individuals.infrastructure.repository.rsql;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

import io.micrometer.common.util.StringUtils;

@Component
public class RSQLSpecificationBuilder {
    
    public <T> Specification<T> createSpecification(String rsqlQuery) {
        if (StringUtils.isBlank(rsqlQuery)) {
            return null;
        }
        
        Node rootNode = new RSQLParser().parse(rsqlQuery);
        return rootNode.accept(new CustomRsqlVisitor<T>());
    }
}