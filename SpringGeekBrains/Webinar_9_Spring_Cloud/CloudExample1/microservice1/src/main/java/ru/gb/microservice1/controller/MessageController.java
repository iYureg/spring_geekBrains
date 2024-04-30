package ru.gb.microservice1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class MessageController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from service1";
    }

}
