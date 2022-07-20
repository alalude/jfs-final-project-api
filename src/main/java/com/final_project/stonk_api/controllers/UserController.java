package com.final_project.stonk_api.controllers;

import com.final_project.stonk_api.controllers.dto.UserDTO;
import com.final_project.stonk_api.entities.User;
import com.final_project.stonk_api.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") // allowing access from all ports
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> getUser(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id){

        return userService.findById(id);
    }

    @GetMapping("/firstname")
    public Iterable<User> getUserByFirstName(@RequestParam String firstname) {
        return userService.findByFirstName(firstname);
    }

    @GetMapping("/lastname")
    public Iterable<User> getUserByLastName(@RequestParam String lastname) {
        return userService.findByLastName(lastname);
    }

    @CrossOrigin
    @PostMapping("/add")
    public User createNewUser(@RequestBody UserDTO newUserDTO) {
        return userService.save(newUserDTO);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable("id") Integer userId,
            @RequestBody UserDTO userDTO
    ) {
        return userService.update(userId, userDTO);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") Integer userId) {

        return userService.delete(userId);

    }
}
