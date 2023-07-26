package com.roger.teste1.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * Responsável pelas configurações do Swagger.
 *
 * @author Janilson Serra, Alfredo Gabriel
 * @since 23/01/2023
 * @version 1.0
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("Bearer",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer").bearerFormat("JWT")))
                .info(new Info().title("Java Teste Eu")
                        .description(
                                "Teste de java no qual Alfredo destruidor e Vivi pano preto.")
                        .version("v0.0.1")
                        .license(new License().name("Defensoria Pública do Estado Pará")
                                .url("http://defensoria.pa.def.br/missao.aspx")))
                .externalDocs(new ExternalDocumentation()
                        .description("Wiki do Projeto no Gitlab")
                        .url("https://gitlab.defensoria.pa.def.br/sistemas-dpe/sistem-relatorio-dpe/-/wikis/home"));
    }
}
