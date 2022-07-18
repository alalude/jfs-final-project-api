package com.final_project.stonk_api.controllers;

import com.final_project.stonk_api.entities.User;
import com.final_project.stonk_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> getUser(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id){

        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            return null;
        }
        return optionalUser.get();
    }

    @GetMapping("/firstname")
    public Iterable<User> getUserByFirstName(@RequestParam String firstname) {
        return userRepository.findByFirstName(firstname);
    }

    @PostMapping("/add")
    public User createNewUser(@RequestBody User user) {
//        User bob = new User(user);
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable("id") Integer id,
            @RequestBody User u
    ) {
        Optional<User> userToUpdateOptional = userRepository.findById(id);
        if (userToUpdateOptional.isEmpty()) {
            return null;
        }
        User userToUpdate = userToUpdateOptional.get();
        if (u.getEmail() != null) {
            userToUpdate.setEmail(u.getEmail());
        }
        if (u.getFirstName() != null) {
            userToUpdate.setFirstName(u.getFirstName());
        }
        if (u.getLastName() != null) {
            userToUpdate.setLastName(u.getLastName());
        }
        if (u.getAvatar() != null) {
            userToUpdate.setAvatar(u.getAvatar());
        }
        return userRepository.save(userToUpdate);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") Integer id) {
        Optional<User> userToDeleteOptional = userRepository.findById(id);
        if (userToDeleteOptional.isEmpty()) {
            return null;
        }
        User userToDelete = userToDeleteOptional.get();
        userRepository.delete(userToDelete);
        return userToDelete;
    }
}
