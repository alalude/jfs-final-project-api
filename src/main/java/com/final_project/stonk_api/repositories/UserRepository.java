package com.final_project.stonk_api.repositories;

import com.final_project.stonk_api.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String firstName);
}
