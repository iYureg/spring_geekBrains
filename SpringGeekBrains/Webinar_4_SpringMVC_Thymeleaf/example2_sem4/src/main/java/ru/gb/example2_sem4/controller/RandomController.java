package ru.gb.example2_sem4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class RandomController {
    private final Random r = new Random();
    @GetMapping({"/random", "/random/{max}"})
    public String getRandom(@PathVariable(value = "max", required = false) Integer max, Model model) {
        Integer rnd = max != null ? r.nextInt(max) : r.nextInt(100);
        model.addAttribute("number", rnd);
        return "random";
    }

    @GetMapping("/random/{min}/{max}")
    public String getSpecRandom(@PathVariable(value = "min") Integer min, @PathVariable(value = "max") Integer max, Model model) {
        Integer num = r.nextInt(min, max);

        model.addAttribute("number", num);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "min_max_random";
    }

    @GetMapping("/randomWithParams")
    public String getRandomNumEx(
            @RequestParam(name = "min", defaultValue = "1") Integer min,
            @RequestParam(name = "max", defaultValue = "100") Integer max,
            Model model) {
        Integer num = r.nextInt(min, max);
        model.addAttribute("number", num);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "min_max_random";
    }
}
