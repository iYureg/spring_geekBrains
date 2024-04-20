package ru.gb.ricAndMorty.services;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.ricAndMorty.models.Characters;
import ru.gb.ricAndMorty.models.Result;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ServiceApiImpl implements ServiceAPI {

    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    private final Environment env;


    @Override
    public Characters getAllCharacters() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Characters> response = restTemplate.exchange(env.getProperty("CHARACTER_API"), HttpMethod.GET, entity, Characters.class);
        return response.getBody();
    }

    @Override
    public Result getCharacterById(Integer id) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        String path = env.getProperty("CHARACTER_API") + "/" + id;
        ResponseEntity<Result> response = restTemplate.exchange(path, HttpMethod.GET, entity, Result.class);
        return response.getBody();
    }

    @Override
    public Characters getSortedCharactersByName() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Characters> response = restTemplate.exchange(env.getProperty("CHARACTER_API"), HttpMethod.GET, entity, Characters.class);
        response.getBody().setResults(response.getBody()
                .getResults()
                .stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList()));

        return response.getBody();
    }

    @Override
    public Characters getSortedCharactersByGender() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Characters> response = restTemplate.exchange(env.getProperty("CHARACTER_API"), HttpMethod.GET, entity, Characters.class);
        response.getBody().setResults(response.getBody()
                .getResults()
                .stream()
                .sorted((o1, o2) -> o1.getGender().compareTo(o2.getGender()))
                .collect(Collectors.toList()));

        return response.getBody();
    }
}
