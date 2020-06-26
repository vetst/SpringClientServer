package springBoot.web.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public RestTemplateConfig(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Bean
    public RestTemplate myRestTemplate() {

        return restTemplateBuilder
                .rootUri("http://localhost:8081/api")
                .basicAuthentication("admin", "admin")
                .build();
    }
}
