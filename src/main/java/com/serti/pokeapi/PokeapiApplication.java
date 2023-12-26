package com.serti.pokeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class PokeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeapiApplication.class, args);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
 
           registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");
 
    }

}
