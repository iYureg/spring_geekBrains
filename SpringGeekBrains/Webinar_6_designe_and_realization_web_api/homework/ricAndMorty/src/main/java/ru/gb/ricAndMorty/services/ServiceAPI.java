package ru.gb.ricAndMorty.services;

import ru.gb.ricAndMorty.models.Characters;
import ru.gb.ricAndMorty.models.Result;

public interface ServiceAPI {
    public Characters getAllCharacters();
    public Result getCharacterById(Integer id);
    public Characters getSortedCharactersByName();
    public Characters getSortedCharactersByGender();
}
