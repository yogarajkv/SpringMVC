package com.sapient.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CourtApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[]{ServiceConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/","/welcome"};
	}

}
