package ru.gb.homeworkSpringCRUD.service;

import org.springframework.stereotype.Service;
import ru.gb.homeworkSpringCRUD.model.User;
import ru.gb.homeworkSpringCRUD.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    //public void deleteById(int id)
    public void deleteById(int id){
        userRepository.deleteById(id);
    }


    // update
    public void updateUser(User user){
        userRepository.updateUser(user);
    }
}
