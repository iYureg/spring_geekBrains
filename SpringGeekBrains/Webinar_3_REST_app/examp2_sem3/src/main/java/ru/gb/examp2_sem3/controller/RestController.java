package ru.gb.examp2_sem3.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello user";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "ciao user";
    }
}
