package ru.gb.homeworkSpringCRUD.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Класс инкапсулирует все используемые приложением запросы к базе данных
 */
@Component
// достаем sql код запросов из application.yaml
@ConfigurationProperties(prefix = "db")
@Getter
@Setter
public class DbQueries {
    private String findAll;
    private String save;
    private String delete;
    private String get;
    private String update;
}
