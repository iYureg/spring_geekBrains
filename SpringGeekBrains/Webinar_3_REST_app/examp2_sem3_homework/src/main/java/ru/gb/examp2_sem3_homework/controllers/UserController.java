package ru.gb.examp2_sem3_homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.examp2_sem3_homework.domain.User;
import ru.gb.examp2_sem3_homework.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService
                .getDataProcessingService()
                .getRepository()
                .getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService
                .getDataProcessingService()
                .getRepository()
                .saveUser(user);
        return "User added from body!";
    }

    // create user from request params
    @PostMapping("/create/{name}/{age}/{email}")
    public void createUserFromRequest(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age,
            @PathVariable("email") String email
    ) {
        registrationService.getDataProcessingService()
                .getRepository()
                .saveUser(registrationService.processRegistration(name, age, email));

        registrationService.getNotificationService().sendNotification(
                "User added from request query!"
        );
    }
}
