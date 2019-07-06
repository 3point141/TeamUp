package com.teamup.controller;

import com.teamup.model.TeamDetails;
import com.teamup.service.PlayerService;
import com.teamup.model.PlayerDetails;
import com.teamup.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @RequestMapping("/all")
    public List<PlayerDetails> getAll(){
        return playerService.showPlayers();
    }

    @PostMapping("/createTeam")
    public boolean checkTeamCreation(@RequestBody TeamDetails teamDetails, Model model){
        return teamService.possible(teamDetails);
    }
}
