package com.teamup.service;

import com.teamup.model.PlayerDetails;
import com.teamup.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@EnableMongoRepositories(basePackageClasses = PlayersRepository.class)
@Configuration
public class PlayerService {

    @Autowired
    private PlayersRepository playersRepository;

    /**
     * To Return all the players present in databse
     *
     * @return List of Player Model Object containing details of every player present in database
     */
    public List<PlayerDetails> showPlayers() {
        playersRepository.deleteAll();
        playersRepository.save(new PlayerDetails("aman", 111));
        return playersRepository.findAll();
    }

    public List<PlayerDetails> randomize(List<PlayerDetails> playerDetails) {
        Collections.shuffle(playerDetails);
        return playerDetails;
    }


    /**
     * Make teams after normalising all the skill level of players
     *
     * @param playerDetails List of the original team data with player name and player skill
     * @return The normalised List of Players divided into teams
     */
    public List<PlayerDetails> teamUpStyle(List<PlayerDetails> playerDetails, int numberOfTeams) {
        playerDetails.sort(Comparator.comparingInt(PlayerDetails::getPlayerRating).reversed());
        List<PlayerDetails> newTeam = new ArrayList<>();

        for(int i=0;i<playerDetails.size();i++)
            newTeam.add(new PlayerDetails());

        int otherTeamIndex = playerDetails.size() / numberOfTeams;
        int normalTraverse = 0;
        for (int i = 0; i < playerDetails.size(); i += otherTeamIndex) {
            assert false;
            newTeam.set(i, playerDetails.get(normalTraverse));
            normalTraverse++;
        }

        List<PlayerDetails> restPlayers=new ArrayList<>();
        for(int i=0;i<playerDetails.size()-numberOfTeams;i++)
            restPlayers.add(new PlayerDetails());

        normalTraverse=0;
        for(int i=numberOfTeams;i<playerDetails.size();i++){
            restPlayers.set(normalTraverse,playerDetails.get(i));
            normalTraverse++;
        }
        assert false;
        restPlayers.sort(Comparator.comparingInt(PlayerDetails::getPlayerRating));
        int j=1;
        normalTraverse=0;
        for(int i=0;i<otherTeamIndex-1;i++){
            int start=j++;
            int k=numberOfTeams;
            while (k-->0){
                newTeam.set(start,restPlayers.get(normalTraverse++));
                start+=otherTeamIndex;
            }
        }
        playerDetails=newTeam;
        return playerDetails;
    }
}
