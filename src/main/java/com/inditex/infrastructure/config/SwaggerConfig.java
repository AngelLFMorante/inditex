package com.inditex.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up OpenAPI (Swagger) documentation for the Inditex API.
 * This class customizes the OpenAPI configuration used for generating API documentation.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Configures the custom OpenAPI settings.
     *
     * @return OpenAPI instance with custom API documentation metadata.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Inditex API")
                        .version("1.0")
                        .description("API for managing product prices"));
    }
}
