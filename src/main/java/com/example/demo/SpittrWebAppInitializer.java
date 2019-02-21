package com.example.demo;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.*;

public class SpittrWebAppInitializer
	extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/", "/test/" };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { spring.config.WebConfig.class };
	}
	
	@Override
	protected javax.servlet.Filter[] getServletFilters() {
		javax.servlet.Filter[] filters;
		
		CharacterEncodingFilter encFilter;
		
		encFilter = new CharacterEncodingFilter();
		encFilter.setEncoding("UTF-8");
		encFilter.setForceEncoding(true);
		
		filters = new javax.servlet.Filter[] {encFilter};
		
		return filters;
	}
}