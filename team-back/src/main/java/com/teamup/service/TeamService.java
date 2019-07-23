package com.teamup.service;

import com.teamup.model.PlayerDetails;
import com.teamup.model.TeamDetails;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class TeamService {

    public boolean possible(TeamDetails teamDetails){
        return teamDetails.getNumberOfPlayers()%teamDetails.getNumberOfTeams()==0;
    }

    /*public List<PlayerDetails> makeTeam(List<PlayerDetails> playerDetails){
        Collections.sort(playerDetails);
    }*/
}

