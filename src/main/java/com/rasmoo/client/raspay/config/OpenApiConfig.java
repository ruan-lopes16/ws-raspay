package com.rasmoo.client.raspay.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic")))
                .info(new Info()
                        .title("RasPay API")
                        .description("API para credenciamento FAKE de transações financeiras")
                        .version("1.0.0")
                        .license(new License()
                                .name("Rasmoo cursos de tecnologia")))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"));
    }
}