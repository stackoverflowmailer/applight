package com.dj.applite.core.servlet;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Servlet context listener for the Web Application. Responsible for bringing up
 * the Guice dependency inject mechanism and wiring of application specific
 * components using Guice.
 * 
 * @author Deepak Jacob
 */
public class AppliteServletContextListener extends GuiceServletContextListener {

    /**
     * Jersey scanner will be looking in these packages for resources and
     * providers
     */
    private static final String SCANNING_LOCATIONS = "com.dj.applite.fund.resource;com.dj.applite.subject.resource;com.dj.applite.core.servlet;org.codehaus.jackson.jaxrs";

    @Override
    protected Injector getInjector() {
	final Map<String, String> servletParameters = Maps.newHashMap();
	servletParameters.put(PackagesResourceConfig.PROPERTY_PACKAGES, SCANNING_LOCATIONS);
	servletParameters.put("com.sun.jersey.config.feature.Trace", "true");
	servletParameters.put("com.sun.jersey.spi.container.ResourceFilters",
	        "com.sun.jersey.api.container.filter.ResourceDebuggingFilterFactory");
	Injector injector = Guice.createInjector(
	        new JerseyServletModule() {
		    @Override
		    protected void configureServlets() {
		        // We are not yet ready for the implementing
		        // persistence,
		        // So commenting the next line :(
		        /* filter("/ajax *//* ").through(PersistFilter.class); */

		        // Pass all the requests with /ajax/* through the
		        // following filter and servlet
		        filter("/ajax/*").through(AppliteSecurityFilter.class);
		        serve("/ajax/*").with(GuiceContainer.class, servletParameters);
		    }
	        });
	return injector;

    }
}
