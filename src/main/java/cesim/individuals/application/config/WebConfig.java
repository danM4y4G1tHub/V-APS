package cesim.individuals.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry){
    registry.addMapping("/api/v1/report/monthly-report")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);

    registry.addMapping("/api/v1/notifications/trig-notification")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("POST")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
  }
}
