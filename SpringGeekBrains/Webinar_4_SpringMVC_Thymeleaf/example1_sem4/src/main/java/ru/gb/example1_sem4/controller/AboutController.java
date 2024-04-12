package ru.gb.example1_sem4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

    @RequestMapping("/about")
    public String getAbout(){
        return "about.html";
    }
}
