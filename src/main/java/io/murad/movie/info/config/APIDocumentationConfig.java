package io.murad.movie.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class APIDocumentationConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("io.murad"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Movie Info API",
                "Simple API for Movie Information",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Md Murad Hossain","https://github.com/mdmuradhossain","murad.hossain.cse@ulab.edu.bd"),
                "API License",
                "https://github.com/mdmuradhossain",
                Collections.emptyList()
        );
    }
}
