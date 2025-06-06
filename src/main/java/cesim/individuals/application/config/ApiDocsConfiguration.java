package cesim.individuals.application.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "FHIR Individuasl Service", description = "Individual management services in a nutshell.", version = "v0.0.1", contact = @Contact(name = "CESIM", email = "cesim@uci.cu")))
public class ApiDocsConfiguration {
        @Bean
        OpenApiCustomizer customizer() {
                return openApi -> openApi.getPaths()
                                .forEach((s, pathItem) -> pathItem.readOperations()
                                                .forEach(operation -> operation.setTags(operation.getTags()
                                                                .stream()
                                                                .map(t -> t.replace("profile-controller", "Api Profile")
                                                                                .replace("authorization-server-endpoints",
                                                                                                "Oauth"))
                                                                .toList())));
        }
}
