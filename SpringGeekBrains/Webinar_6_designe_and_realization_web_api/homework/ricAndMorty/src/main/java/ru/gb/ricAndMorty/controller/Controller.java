package ru.gb.ricAndMorty.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.ricAndMorty.services.ServiceAPI;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final ServiceAPI serviceAPI;

    @GetMapping("/characters")
    public String getCharacters(Model model) {
        model.addAttribute("characters", serviceAPI.getAllCharacters().getResults());
        return "characters";
    }

    @GetMapping("/character/{id}")
    public String getCharacter(@PathVariable Integer id, Model model) {
        model.addAttribute("character", serviceAPI.getCharacterById(id) );
        return "character";
    }

    @GetMapping("/characters/name")
    public String getCharactersByName(Model model) {
        model.addAttribute("characters", serviceAPI.getSortedCharactersByName().getResults());
        return "characters";
    }

    @GetMapping("/characters/gender")
    public String getCharactersByGender(Model model) {
        model.addAttribute("characters", serviceAPI.getSortedCharactersByGender().getResults());
        return "characters";
    }
}
