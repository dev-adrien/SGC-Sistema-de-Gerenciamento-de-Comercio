package com.adrien.sgc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SGC - Sistema de Gestão Comercial")
                        .description("API RESTful para controle de estoque, frente de caixa (PDV), gestão de vendas e auditoria.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Adrien Bezerra Leandro")
                                .email("adrienbzr@outlook.com")));
    }
}