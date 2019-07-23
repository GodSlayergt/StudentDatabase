package com.gt.springmvchibernate.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext root= new AnnotationConfigWebApplicationContext();
		root.register(WebConfigure.class);
		
		ServletRegistration.Dynamic dispatcher =servletContext.addServlet("dispatcher",new DispatcherServlet(root));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		

	}

}
