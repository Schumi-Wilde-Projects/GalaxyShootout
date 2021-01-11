package schumiwilde.projects;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@ComponentScan(basePackages = "schumiwilde.projects")
@EnableSpringConfigured
@EnableAspectJAutoProxy
public class Config {

}
