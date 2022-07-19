package com.final_project.stonk_api.controllers;


import com.final_project.stonk_api.controllers.dto.TeamDTO;
import com.final_project.stonk_api.entities.Team;
import com.final_project.stonk_api.service.TeamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
//keep
    @GetMapping
    public Iterable<Team> getTeam(){
        return teamService.findAll();
    }
    //keep
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable("id") Integer id){

        return teamService.findById(id);
    }
//change
    @GetMapping("/name")
    public Iterable<Team> getTeamByName(@RequestParam String name) {
        return teamService.findByName(name);
    }

    //keep
    @PostMapping("/add")
    public Team createNewTeam(@RequestBody TeamDTO newTeamDTO) {
        return teamService.save(newTeamDTO);
    }
    //keep
    @PutMapping("/{id}")
    public Team updateTeam(
            @PathVariable("id") Integer teamId,
            @RequestBody TeamDTO teamDTO
    ) {
        return teamService.update(teamId, teamDTO);
    }
    //keep
    @DeleteMapping("/{id}")
    public Team deleteTeam(@PathVariable("id") Integer teamId) {

        return teamService.delete(teamId);

    }
}
