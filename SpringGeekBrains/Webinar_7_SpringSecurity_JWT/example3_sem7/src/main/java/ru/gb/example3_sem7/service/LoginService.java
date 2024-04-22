package ru.gb.example3_sem7.service;

import org.springframework.stereotype.Service;
import ru.gb.example3_sem7.api.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {
    Map<String, String> users = new HashMap<>(Map.of("username", "password", "admin", "admin"));

    public Optional<Integer> login(UserDTO userDTO) {
        String password = users.get(userDTO.username());

        if(password!= null && password.equals(userDTO.password())) {
            return Optional.of(1);
        }

        return Optional.empty();
    }
}
