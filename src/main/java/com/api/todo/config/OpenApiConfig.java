package com.api.todo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("To-do API")
                        .version("1.0")
                        .description("API para gerenciamento de tarefas- To-Do List")
                        .contact(new Contact()
                                .name("Gustavo Penha")
                                .email("gustavopenhadev@gmail.com")
                                .url("https://github.com/gustavopenha07"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor local")
                ));
    }
}

