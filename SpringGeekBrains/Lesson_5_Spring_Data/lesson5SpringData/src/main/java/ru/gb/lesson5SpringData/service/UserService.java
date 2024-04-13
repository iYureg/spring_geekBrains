package ru.gb.lesson5SpringData.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.gb.lesson5SpringData.model.User;
import ru.gb.lesson5SpringData.repository.UserRepository;

import java.util.List;

@Data
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        userRepository.save(new User(null, "Evgeny", "evgen@mail.net"));
        userRepository.save(new User(null, "John", "jonny@mail.net"));
        userRepository.save(new User(null, "Kate", "kate@mail.net"));

        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
