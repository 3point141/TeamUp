package com.teamup.service;
import com.teamup.model.PlayerDetails;
import com.teamup.repository.PlayersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories(basePackageClasses = PlayersRepository.class)
@Configuration
public class PlayerService {

    @Autowired
    private PlayersRepository playersRepository;

    public List<PlayerDetails> showPlayers(){
        playersRepository.deleteAll();
        playersRepository.save(new PlayerDetails("aman",111));
        return playersRepository.findAll();
    }

}
