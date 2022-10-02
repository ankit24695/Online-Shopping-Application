package com.shopping;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.annotations.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}
	
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.shopping"))
				.build()
				.apiInfo(getApiInfo());
				
	}
	
	 private ApiInfo getApiInfo() {
	       return new ApiInfo(
	    		   "Ecommerce website",
	    		   "Team members :\n \"Ankit Chaurasia\",\r\n"
	    		   + "\"Gautam Deo prasad\",\r\n"
	    		   + "\"Shivraj krishna punjare\",\r\n"
	    		   + " \"Tanya kiran\",\r\n"
	    		   + "\"Rakesh D B\"",

	    		   "1.0",
	    		   "Free to use",
	    		   new springfox.documentation.service.Contact("Online Shopping", "https://github.com/ankit24695/Online-Shopping-Application", "rakeshdb9141@gmail.com"),
	    		   "API License",
	    		   "https://github.com/ankit24695/Online-Shopping-Application",
	    		   Collections.emptyList());
	    		   
	    }
	
	

}
