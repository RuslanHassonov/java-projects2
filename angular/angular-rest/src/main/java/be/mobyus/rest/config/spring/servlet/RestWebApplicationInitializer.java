package be.mobyus.rest.config.spring.servlet;

import be.mobyus.rest.config.spring.RestModuleConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RestWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/api/*", "/*"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new GenericFilterBean() {
            @Override
            public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
                chain.doFilter(new ContentCachingRequestWrapper((HttpServletRequest) request), response);
            }
        }};
    }

    @Override
    protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
        return new ApplicationContextInitializer[] { app -> {
            try {
                app.getEnvironment().getPropertySources().addLast(new ResourcePropertySource("classpath:/application.properties"));
            } catch (IOException e) {
                logger.error("application.properties could not be loaded. This file should be bundled within the application itself", e);
                throw new RuntimeException(e);
            }
        } };
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RestModuleConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{};
    }
}
