package ru.gb.examp2_sem3_homework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.examp2_sem3_homework.domain.User;
import ru.gb.examp2_sem3_homework.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");

        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge(
                dataProcessingService.getRepository().getUsers());
    }


    //метод filterUsersByAge
    //Подсказка  @GetMapping("/filter/{age}")
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable Integer age){

        return age != null
                ? dataProcessingService.filterUsersByAge(
                dataProcessingService.getRepository().getUsers(), age)
                : dataProcessingService.getRepository().getUsers();
    }

    //метод calculateAverageAge
    //Подсказка  @GetMapping("/calc")
    @GetMapping("/calc")
    public String calcAverageAge() {
        return String.format("Средний возраст юзеров: %d",
                (int) dataProcessingService.calculateAverageAge(
                        dataProcessingService.getRepository().getUsers()
                )
        );
    }

}
