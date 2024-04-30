package ru.gb.openFeign_service.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "ru.gb.openFeign_service.proxy")
public class ProjectConfig {
}
