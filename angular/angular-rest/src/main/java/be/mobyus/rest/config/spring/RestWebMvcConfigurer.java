package be.mobyus.rest.config.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RestWebMvcConfigurer extends WebMvcConfigurerAdapter {

	private static final int NINETY_DAYS_IN_SECS = 7776000;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
		ResourceHttpMessageConverter resourceHttpMessageConverter = new ResourceHttpMessageConverter();
		converters.add(resourceHttpMessageConverter);
		converters.add(mappingJackson2HttpMessageConverter);
	}

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/ui/**").setViewName("forward:/index.html");
		registry.addViewController("/").setViewName("forward:/index.html");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//Everything in 'app' is fingerprinted, we keep a long cache. Note: this fingerprinting only occurs when making a production build
		registry.addResourceHandler("/app/**").addResourceLocations("/app/").setCachePeriod(NINETY_DAYS_IN_SECS);
		registry.addResourceHandler("/**").addResourceLocations("/");
	}
}
