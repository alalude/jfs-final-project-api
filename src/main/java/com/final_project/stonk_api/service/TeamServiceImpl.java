package com.final_project.stonk_api.service;

import com.final_project.stonk_api.controllers.dto.TeamDTO;
import com.final_project.stonk_api.entities.Team;
import com.final_project.stonk_api.repositories.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team save(TeamDTO teamDTO){
        Team team = new Team(teamDTO);
        return teamRepository.save(team);
    }

    @Override
    public Team update(Integer id, TeamDTO t) {
        Optional<Team> teamToUpdateOptional = teamRepository.findById(id);
        if (teamToUpdateOptional.isEmpty()) {
            return null;
        }
        Team teamToUpdate = teamToUpdateOptional.get();
       
        if (t.getName() != null) {
            teamToUpdate.setName(t.getName());
        }
        if (t.getAvatar() != null) {
            teamToUpdate.setAvatar(t.getAvatar());
        }
//        if (t.getOwner() != null) {
//            teamToUpdate.setOwner(t.getOwner());
//        }
        return teamRepository.save(teamToUpdate);
    }

    @Override
    public Team delete(Integer teamId) {

        Optional<Team> teamToDeleteOptional = teamRepository.findById(teamId);
        if (teamToDeleteOptional.isEmpty()) {
            return null;
        }
        Team teamToDelete = teamToDeleteOptional.get();
        teamRepository.delete(teamToDelete);
        return teamToDelete;

    }

    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Integer teamId) {

        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if(optionalTeam.isEmpty()){
            // throw an exception if the ID is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no team with the ID provided.");
        }
        return optionalTeam.get();
    }

    @Override
    public List<Team> findByName(String name) {
        List<Team> optionalTeam = teamRepository.findByName(name);
        if(optionalTeam.isEmpty()){
            // throw an exception if the name is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no team with the first name provided.");
        }
        return teamRepository.findByName(name);
    }

}
