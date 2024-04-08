package ru.gb.lesson4Thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lesson4Thymeleaf.model.User;
import ru.gb.lesson4Thymeleaf.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        userRepository.save(new User(null, "Evgeny", "evgen@mail.net"));
        userRepository.save(new User(null, "John", "jonny@mail.net"));
        userRepository.save(new User(null, "Kate", "kate@mail.net"));
        userRepository.save(new User(null, "Sara", "sara@mail.net"));
        userRepository.save(new User(null, "Eric", "eric@mail.net"));

        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
