package com.spring.jpa.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PocApplication {

	private String apiBasePackage = "com.spring.jpa.poc";
	private String apiName = "Spring Data JPA Example API";
	private String apiDescription = "Documentation TEST API v1.0";
	private String apiVersion = "1.0";
	
	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage(apiBasePackage))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version(apiVersion).title(apiName).description(apiDescription).build());
	}
}
