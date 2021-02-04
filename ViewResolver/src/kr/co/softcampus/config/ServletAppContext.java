package kr.co.softcampus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Spring MVC프로젝트에 관련된 설정을 하는 클래스 (컨트롤러 빈을 만들어야되므로 @Configuration어노테이션 붙임)
@Configuration
// Controller 어노테이션이 세팅되어 있는 클래스를 Controller로 등록함
@EnableWebMvc
@ComponentScan("kr.co.softcampus.controller") // ()안의 패키지에 들어있는 bean을 스캔하도록 설정
public class ServletAppContext implements WebMvcConfigurer{
	// Controller의 메서드가 반환하는 jsp파일의 prefix, suffix를 지정하도록 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 정적파일(HTML,CSS등)의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
}
