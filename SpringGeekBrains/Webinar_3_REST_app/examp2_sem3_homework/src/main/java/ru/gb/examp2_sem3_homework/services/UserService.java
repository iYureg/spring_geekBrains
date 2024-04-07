package ru.gb.examp2_sem3_homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.examp2_sem3_homework.domain.User;

@Service
public class UserService {
    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notificationService.notifyUser(user);

        return user;
    }
}
