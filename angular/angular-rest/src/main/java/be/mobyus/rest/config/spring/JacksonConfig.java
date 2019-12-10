package be.mobyus.rest.config.spring;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper mapper() {
        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().serializationInclusion(NON_ABSENT).featuresToDisable(WRITE_DATES_AS_TIMESTAMPS)
                .annotationIntrospector(new JacksonAnnotationIntrospector()).build();
        mapper.findAndRegisterModules();
        return mapper;
    }
}
