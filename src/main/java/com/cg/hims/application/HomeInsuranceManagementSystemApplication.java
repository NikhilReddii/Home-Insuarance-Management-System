package com.cg.hims.application;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages = "com.cg.hims")
@EntityScan(basePackages = "com.cg.hims.entities")
@EnableJpaRepositories(basePackages = "com.cg.hims.repository")
@EnableOpenApi
public class HomeInsuranceManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeInsuranceManagementSystemApplication.class, args);
	}
	
	@Bean
	  public Docket openApiEmployeeStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-homeInsurance-management")
	        .select()
	        .paths(himsPaths())
	        .build();
	  }

	  private Predicate<String> himsPaths() {
	    return regex(".*/hims/.*");
	  }
	  
//	  @Bean
//		public RestTemplate getRestTemplate() {
//			return new RestTemplate();
//		}


}
