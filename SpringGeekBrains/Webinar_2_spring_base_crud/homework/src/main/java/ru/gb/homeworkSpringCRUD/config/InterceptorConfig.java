package ru.gb.homeworkSpringCRUD.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.gb.homeworkSpringCRUD.interceptor.RequestInterceptor;

@Configuration
@ComponentScan(basePackages = "ru.gb.homeworkSpringCRUD.interceptor.RequestInterceptor")
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());
    }

}
