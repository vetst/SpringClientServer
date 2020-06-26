package springBoot.web.config.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate RestTemplateConfig(RestTemplateBuilder restTemplateBuilder) {
        return  restTemplateBuilder
                .rootUri("http://localhost:8081/api")
                .basicAuthentication("admin", "admin")
                .build();
    }
}
