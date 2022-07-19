package com.final_project.stonk_api.service;

import com.final_project.stonk_api.controllers.dto.UserDTO;
import com.final_project.stonk_api.entities.User;

import java.util.List;

public interface UserService {
    User save(UserDTO userDTO);
    User update(Integer userId, UserDTO userDTO);
    User delete(Integer userId);
    Iterable<User> findAll();
    User findById(Integer userId);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
}
