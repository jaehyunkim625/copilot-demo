package com.example.copilot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

  // URL: http://localhost:8080/swagger-ui/

  @Bean
  public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
              .ignoredParameterTypes(Errors.class)
              .select()
              .apis(RequestHandlerSelectors.basePackage("com.example.copilot.demo"))
              .paths(PathSelectors.any())
              .build();
  }
}
