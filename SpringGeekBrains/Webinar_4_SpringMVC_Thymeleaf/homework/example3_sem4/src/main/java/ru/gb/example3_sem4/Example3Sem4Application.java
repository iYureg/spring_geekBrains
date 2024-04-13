package ru.gb.example3_sem4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Example3Sem4Application implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(Example3Sem4Application.class, args);
	}
}
