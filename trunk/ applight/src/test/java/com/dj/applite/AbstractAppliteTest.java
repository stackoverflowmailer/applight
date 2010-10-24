package com.dj.applite;

import java.util.EventListener;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.dj.applite.core.servlet.AppliteServletContextListener;
import com.google.common.collect.Lists;
import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.api.client.config.ClientConfig;

/**
 * Applite specific details such as context, port, scheme, other http path
 * details are specified here.
 * 
 * @author Deepak Jacob
 */
public abstract class AbstractAppliteTest extends JettyTestContainer {

    private static final String APPLITE_AJAX_PATTERN = "/ajax";
    private static final String CONTEXT = "/";

    @Override
    protected String getContextPath() {
	return CONTEXT;
    }

    @Override
    protected List<HttpServlet> getServlets() {
	List<HttpServlet> servletList = Lists.newArrayList();
	return servletList;
    }

    @Override
    protected String getPattern() {
	return APPLITE_AJAX_PATTERN;
    }

    @Override
    protected List<Filter> getFilters() {
	List<Filter> filterList = Lists.newArrayList();
	filterList.add(new GuiceFilter());
	return filterList;
    }

    @Override
    protected List<EventListener> getEventListeners() {
	List<EventListener> listenerList = Lists.newArrayList();
	listenerList.add(new AppliteServletContextListener());
	return listenerList;
    }

    @Override
    protected void registerProviderClasses(final ClientConfig cc) {
	cc.getClasses().add(JacksonJsonProvider.class);
    }
}
