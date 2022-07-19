package com.final_project.stonk_api.service;

import com.final_project.stonk_api.controllers.dto.UserDTO;
import com.final_project.stonk_api.entities.User;
import com.final_project.stonk_api.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDTO userDTO){
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, UserDTO u) {
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

    @Override
    public User delete(Integer userId) {

        Optional<User> userToDeleteOptional = userRepository.findById(userId);
        if (userToDeleteOptional.isEmpty()) {
            return null;
        }
        User userToDelete = userToDeleteOptional.get();
        userRepository.delete(userToDelete);
        return userToDelete;

    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer userId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            // throw an exception if the ID is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no user with the ID provided.");
        }
        return optionalUser.get();
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        List<User> optionalUser = userRepository.findByFirstName(firstName);
        if(optionalUser.isEmpty()){
            // throw an exception if the name is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no user with the first name provided.");
        }
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        List<User> optionalUser = userRepository.findByLastName(lastName);
        if(optionalUser.isEmpty()){
            // throw an exception if the name is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no user with the last name provided.");
        }
        return userRepository.findByLastName(lastName);
    }
}
