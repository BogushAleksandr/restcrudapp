package com.ua.SPAREST.backside.restcrudapp.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    /*Open http://localhost:8080/DocRestApi/swagger-ui.html to see the Swagger UI documentation in the browser.*/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //enabling swagger-ui part for visual documentation
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/resources/");
    }
}

