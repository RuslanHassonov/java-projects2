package be.mobyus.rest.config.spring;

import be.mobyus.service.spring.ServiceModuleConfig;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableWebSecurity
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "be.mobyus.rest")
@Import(ServiceModuleConfig.class)
public class RestModuleConfig {

}

