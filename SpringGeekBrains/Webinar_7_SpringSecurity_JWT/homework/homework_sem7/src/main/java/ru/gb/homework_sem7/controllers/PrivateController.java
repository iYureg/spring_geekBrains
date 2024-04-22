package ru.gb.homework_sem7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivateController {

    @GetMapping("/private-data")
    public String privateData() {
        return "private-data.html";
    }
}
