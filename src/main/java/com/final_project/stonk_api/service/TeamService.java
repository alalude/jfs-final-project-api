package com.final_project.stonk_api.service;

import com.final_project.stonk_api.controllers.dto.TeamDTO;
import com.final_project.stonk_api.entities.Team;

import java.util.List;

public interface TeamService {
    Team save(TeamDTO teamDTO);
    Team update(Integer teamId, TeamDTO teamDTO);
    Team delete(Integer teamId);
    Iterable<Team> findAll();
    Team findById(Integer teamId);
//    change
    List<Team> findByName(String name);
}
