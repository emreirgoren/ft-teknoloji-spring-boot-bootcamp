package com.patika.bloghubservice.config;




import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bloghubServiceOpenAPI () {
        return new OpenAPI()
                .info(new Info()
                        .title("Bloghub Servis")
                        .description("Bloghub CRUD Operations.")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Bloghub Service Project Documentation")
                        .url("https://springdoc.org/"));
    }


}
