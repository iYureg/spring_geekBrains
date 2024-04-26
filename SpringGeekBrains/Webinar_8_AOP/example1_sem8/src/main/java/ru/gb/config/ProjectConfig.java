package ru.gb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.aspect.AnnotationLoggerAspect;
import ru.gb.aspect.LoggingAspect;

@Configuration
@ComponentScan(basePackages = "ru.gb")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public LoggingAspect aspect(){
        return new LoggingAspect();
    }


    @Bean
    public AnnotationLoggerAspect annotationLoggerAspect(){
        return new AnnotationLoggerAspect();
    }
}
