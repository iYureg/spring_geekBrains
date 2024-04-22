package ru.gb.example3_sem7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class Example3Sem7Application {

	public static void main(String[] args) {
		SpringApplication.run(Example3Sem7Application.class, args);
	}

}
