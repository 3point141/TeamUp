package com.teamup.service;

import com.teamup.model.TeamDetails;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamService {

    public boolean possible(TeamDetails teamDetails){
        return teamDetails.getNumberOfPlayers()%teamDetails.getNumberOfTeams()==0;
    }
}
