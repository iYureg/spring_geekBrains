package ru.gb.homeworkSpringCRUD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.homeworkSpringCRUD.aspect.LoggingAspect;
import ru.gb.homeworkSpringCRUD.aspect.TimingAspect;

@Configuration
@ComponentScan(basePackages = "ru.gb.homeworkSpringCRUD")
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public TimingAspect timingAspect() {
        return new TimingAspect();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
