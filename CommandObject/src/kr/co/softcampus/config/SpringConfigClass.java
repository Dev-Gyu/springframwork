package kr.co.softcampus.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/* 1번방식
public class SpringConfigClass implements WebApplicationInitializer{
	 자바로 스프링의 기본설정을 하는것은 2가지가있음.
	 1. WebApplicationInitializer 인터페이스 구현
	 2. AbsrtacteAnnotationcConfigDispatcherServletInitializer 상속
	 웹어플리케이션 실행시 WebApplicationInitializer 인터페이스를 구현, 
	 혹은 AbstractAnnotationConfigDispatcherServletInitializer상속한 클래스가 있으면
	 1번의 경우 Web.xml의 설정파일 대신 해당 클래스의 onStartup 메소드 실행함.
	 이 메소드안에 설정정보를 세팅하는 코드들이 와야함
	 2번은 이미 메소드들이 정의되어있고, 그 메소드들 안에 필요한 설정코드들만 작성하면 되는 구조.
	 
	 1번은 코드가 복잡하다는 단점이 있는반면 확장성, 유연성이 높고
	 2번은 코드가 간단해지는 장점이 있는반면 확장성, 유연성이 낮다
	 */
	
	/* 1번방식
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Spring MVC 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다.
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		servletAppContext.register(ServletAppContext.class);
		
		// 1. 요청발생시 요청을 처리하는 서블릿을 DispatcherServlet으로 설정해준다.
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext); // Spring MVC의 DispatcherServlet 객체 생성(매개변수로 spring설정클래스 지정하여 기본세팅함)
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet); // 웹브라우저의 요청을 처리하는 서블릿을 DispatcherServlet으로 지정하는것
		
		// 디스패처 서블릿 부가설정
		servlet.setLoadOnStartup(1); // Mapping된 url요청에 대해 가장 먼저 해당 서블릿이 먼저 대응하도록 설정하는것
		servlet.addMapping("/"); // 모든요청에 대해 해당 서블릿을 매핑하겠다는 의미
		
		// 2. Bean을 정의하는 클래스를 지정한다.
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext); // 리스너설정
		servletContext.addListener(listener); // 서블릿에 해당 리스너 등록
		
		// 파라미터 인코딩 설정 ( web.xml의 필터설정하는것 )
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForServletNames(null, false, "dispatcher");
	}
}
*/

// 2번방식
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	// 프로젝트에서 사용할 Bean들을 정의하기 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppContext.class};
	}
	
	// Spring MVC 프로젝트 설정을 위한 클래스를 지정한다
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletAppContext.class};
	}

	// DispatcherServlet에 매핑할 주소를 지정
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"}; // 모든 url에 대해 서블릿을 매핑하겠다.
	}
	
	// 파라미터 인코딩 필터 설정
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
}
