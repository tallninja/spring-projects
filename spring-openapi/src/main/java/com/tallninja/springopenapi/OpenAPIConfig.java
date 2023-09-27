package com.tallninja.springopenapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class OpenAPIConfig {

    @Value("${app.openapi.info.title}")
    private String title;

    @Value("${app.openapi.info.description}")
    private String description;

    @Value("${app.openapi.info.version}")
    private String version;

    @Value("${app.openapi.server.dev-url}")
    private String devUrl;

    @Value("${app.openapi.server.prod-url}")
    private String prodUrl;

    @Value("${app.openapi.contact.name}")
    private String contactName;

    @Value("${app.openapi.contact.email}")
    private String contactEmail;

    @Value("${app.openapi.contact.url}")
    private String contactUrl;

    @Value("${app.openapi.license.name}")
    private String licenseName;

    @Value("${app.openapi.license.url}")
    private String licenseUrl;

    @Bean
    public OpenAPI openAPI() {
        // OpenAPI development server properties
        Server devServer = new Server()
                .url(devUrl)
                .description("Server URL in development environment");

        // OpenAPI production server properties
        Server prodServer = new Server()
                .url(prodUrl)
                .description("Server URL in production environment");

        // OpenAPI contact properties
        Contact contact = new Contact()
                .name(contactName)
                .email(contactEmail)
                .url(contactUrl);

        // OpenAPI License Properties
        License license = new License()
                .name(licenseName)
                .url(licenseUrl);

        Info info = new Info()
                .title(title)
                .description(description)
                .version(version)
                .license(license)
                .contact(contact);

        return new OpenAPI()
                .servers(List.of(devServer, prodServer))
                .info(info);
    }

}
