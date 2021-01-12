package com.gyus.boardProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("index");
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:/properties/messages");
		source.setDefaultEncoding("UTF-8");
		source.setCacheSeconds(60);
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}


}
