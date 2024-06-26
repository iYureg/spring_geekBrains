package ru.gb.example2_sem7.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.example2_sem7.services.ProductService;

@Controller
public class MainPageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/main")
    public String getMain(Authentication a, Model model) {
        model.addAttribute("username", a.getName());
        model.addAttribute("products", productService.getProducts());
        return "main.html";
    }
}
