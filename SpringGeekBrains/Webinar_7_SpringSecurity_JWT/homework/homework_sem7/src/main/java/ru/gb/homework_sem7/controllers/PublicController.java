package ru.gb.homework_sem7.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/")
    public String startPage() {
        return "index.html";
    }

    @GetMapping("/public-data")
    public String publicData() {
        return "public-data.html";
    }

    @GetMapping("/logout")
    public String logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication!= null) {
            authentication.getPrincipal();
        }
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }
}
