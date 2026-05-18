package org.serratec.aula06.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("yanmartinsd3@gmail.com");
        contact.setName("Yan Martins de Oliveira");
        contact.setUrl("https://www.linkedin.com/in/yan-martins-de-oliveira-7694a71a3/");
        License apacheLicense = new License().name("Apache License").url("https://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info().title("API de Teste").version("1.0").contact(contact).description("API para testes diversos").termsOfService("https://github.com/YanYMO").license(apacheLicense);

        return new OpenAPI().info(info);
    }
}
