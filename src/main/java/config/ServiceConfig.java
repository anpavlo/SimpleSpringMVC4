package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("service")
@Import(value = { SecurityConfig.class })
public class ServiceConfig {
   
     

}