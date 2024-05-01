package ru.gb.homeworkSpringCRUD.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.homeworkSpringCRUD.model.User;
import ru.gb.homeworkSpringCRUD.repositories.UserRepository;
import ru.gb.homeworkSpringCRUD.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public String findAll(Model model){
        List<User> users = userService.findAll();


        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    //@GetMapping("user-delete/{id}")
    @GetMapping("/delete/{id}")
    public String deleteUserById(User user){
        userService.deleteById(user.getId());
        return "redirect:/users";
    }


    // update user by id
    @GetMapping("/update/{id}")
    public String updateUserForm(User user) {

        // mapping to update form page
        return "user-update";
    }


    // update user form page
    @PostMapping("/update")
    public String updateUser(User user){
        userService.updateUser(user);
        // redirect to userlist
        return "redirect:/users";
    }

    // get User by id
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable(name = "id") Integer id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }
}
