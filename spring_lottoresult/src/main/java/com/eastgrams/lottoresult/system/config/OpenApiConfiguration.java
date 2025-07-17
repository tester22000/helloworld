package com.eastgrams.lottoresult.system.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Lotto Result Spring Sample")
                        .description("API documentation for Lotto Result Spring Sample")
                        .version("1.0")
                        .license(new License().name("MIT License").url("https://mit-license.org/")));
    }
}
