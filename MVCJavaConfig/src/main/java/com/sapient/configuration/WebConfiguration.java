package com.sapient.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sapient.interceptors.MeasurementInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.sapient")
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	ContentNegotiationManager cnm;
	
	
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		Map<String,MediaType> mediatypes = new HashMap<String, MediaType>();
		mediatypes.put("html", MediaType.TEXT_HTML);
		/*mediatypes.put("pdf", new MediaType("application/pdf"));
		mediatypes.put("xls", new MediaType("application/vnd.ms-excel"));
		*/mediatypes.put("xml", MediaType.APPLICATION_XML);
		mediatypes.put("json", MediaType.APPLICATION_JSON);
		configurer.mediaTypes(mediatypes);
		
	}
	
	@Bean
	ContentNegotiatingViewResolver  contentNegotiatingViewResolver()
	{
		ContentNegotiatingViewResolver vr = new ContentNegotiatingViewResolver();
		List<ViewResolver> vrList = new ArrayList<ViewResolver>();
		vrList.add(internalResourceViewResolver());
		vr.setViewResolvers(vrList);
		vr.setContentNegotiationManager(cnm);
		return vr;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(measurementInterceptor());
	}
	
	@Bean
	public HandlerInterceptor measurementInterceptor()
	{
		return new MeasurementInterceptor();
	}
	
	@Bean
	public ViewResolver internalResourceViewResolver()
	{
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("/WEB-INF/views/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	
	
	
}
