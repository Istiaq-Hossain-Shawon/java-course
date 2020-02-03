package com.spring.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.spring.practice.controllers"})
public class ServletConfig implements WebMvcConfigurer{

	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	// Configuration to render STATIC CONTENTS (IMAGE, CSS, JS)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler for -

		// IMAGES
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");

		// CSS
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");

		// JAVASCRIPT
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");		
			
		
	}
	@Bean
    public CommonsMultipartResolver multipartResolver(){

        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        return resolver;
    }
	/*
	 * @Bean public CommonsMultipartResolver multiPartResolver(){
	 * CommonsMultipartResolver resolver = new CommonsMultipartResolver(); return
	 * resolver; }
	 */
}


