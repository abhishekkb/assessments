package com.finra.app;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableScheduling
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

	private static Class<Application> application = Application.class;
	
    @Bean
    public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory mpcFactory = new MultipartConfigFactory();
		mpcFactory.setMaxFileSize("10240KB");
		mpcFactory.setMaxRequestSize("10240KB");
        return mpcFactory.createMultipartConfig();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder saBuilder) {
        return saBuilder.sources(application);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
