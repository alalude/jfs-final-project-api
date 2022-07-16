package com.final_project.stonk_api.controllers;

import com.final_project.stonk_api.entities.User;
import com.final_project.stonk_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public User createNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
