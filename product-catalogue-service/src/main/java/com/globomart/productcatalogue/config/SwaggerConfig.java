package com.globomart.productcatalogue.config;



import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport{


		/*@Bean
		public Docket productApi() {
			return new Docket(DocumentationType.SWAGGER_2).select()
	                            .apis(RequestHandlerSelectors.basePackage("com.globomart.productcatalogue.controller")).paths(PathSelectors.ant("/productcatalogue/*")).build();
		}
		@Override
		protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	              registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}*/
	
	  @Bean 
	    public Docket api() {  
	        return new Docket(DocumentationType.SWAGGER_2)   
	          .select()                                   
	          .apis(RequestHandlerSelectors.basePackage("com.globomart.productcatalogue.controller"))               
	          .paths(Predicates.or(regex("/v2/api/products.*"),regex("/api/products.*"))) // for different URI paths
	          //.paths(regex("/v2/api/products.*"))
	          
	          .build();                                            
	    }
	  
	  @Override
		protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	              registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
}


