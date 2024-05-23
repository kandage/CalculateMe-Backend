package com.ains.groupit.calculateme.util.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("com.ains.groupit.calculateme")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CalculateMe API")
                        .description("Calculate Me Application")
                        .version("v0.0.1")
                        .license(new License().name("RUHI CONSTRUCTIONS IT")))
                .externalDocs(new ExternalDocumentation()
                        .description("Calculate Me Documentation"));
    }
}
