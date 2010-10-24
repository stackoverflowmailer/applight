package com.dj.applite;

import java.util.Date;
import java.util.EventListener;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dj.applite.core.servlet.AppliteServletContextListener;
import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * During maven test phase this brings up an embedded jetty container and
 * executes all test cases against this container.
 *
 * @author Deepak Jacob
 */
public abstract class JettyTestContainer {

    private int port = 8080;

    private String host = "localhost";

    private String scheme = "http://";

    private Server server = null;

    private static Logger logger = LoggerFactory.getLogger(JettyTestContainer.class);

    public int getPort() {
        return port;
    }

    public void setPort(final int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(final String scheme) {
        this.scheme = scheme;
    }

    @Before
    public void startContainer() throws Exception {
        logger.debug("======== Starting the embedded Jetty Server {}", new Date());
        server = new Server();
        Connector connector = new SelectChannelConnector();
        connector.setHost("0.0.0.0");
        connector.setPort(getPort());
        server.setConnectors(new Connector[]{connector});
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        context.addFilter(GuiceFilter.class, "/*", 0);
        context.addEventListener(new AppliteServletContextListener());
        context.addServlet(DefaultServlet.class, "/");
        // start the server
        server.start();
        // server.join();
        logger.debug("======== Started the embedded Jetty Server {}", new Date());
    }

    private void addEventListeners(final ServletContextHandler scHandler) {
        for (EventListener eventListener : getEventListeners()) {
            scHandler.addEventListener(eventListener);
        }
    }

    private void addFiltersToContextHandler(final ServletContextHandler scHandler) {
        for (Filter filter : getFilters()) {
            int i = 1;
            scHandler.addFilter(new FilterHolder(filter), getPattern(), 1);
            i++;
        }
    }

    private void addServletsToContextHandler(final ServletContextHandler scHandler) {
        for (HttpServlet httpServlet : getServlets()) {
            scHandler.addServlet(new ServletHolder(httpServlet), getPattern());
        }
    }

    @After
    public void stopContainer() throws Exception {
        logger.debug("======== Stopping the embedded Jetty Server {}", new Date());
        server.stop();
        server.destroy();
        logger.debug("======== Stopped the embedded Jetty Server {}", new Date());
    }

    protected WebResource getWebResource() {
        Client client = getClient();
        return client.resource(getScheme() + getHost() + ":" + getPort() + getPattern());
    }

    protected Client getClient() {
        ClientConfig cc = new DefaultClientConfig();
        registerProviderClasses(cc);
        return Client.create(cc);
    }

    protected abstract String getContextPath();

    protected abstract List<HttpServlet> getServlets();

    protected abstract String getPattern();

    protected abstract List<Filter> getFilters();

    protected abstract List<EventListener> getEventListeners();

    protected abstract void registerProviderClasses(ClientConfig cc);
}
