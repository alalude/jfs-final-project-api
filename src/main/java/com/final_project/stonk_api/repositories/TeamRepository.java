package com.final_project.stonk_api.repositories;

import com.final_project.stonk_api.entities.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    List<Team> findByName(String name);
}
