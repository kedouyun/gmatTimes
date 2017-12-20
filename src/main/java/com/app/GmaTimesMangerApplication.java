package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GmaTimesMangerApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GmaTimesMangerApplication.class, args);
	}
	
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(GmaTimesMangerApplication.class);  
    }  
}
