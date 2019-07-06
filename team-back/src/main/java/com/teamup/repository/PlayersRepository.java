package com.teamup.repository;

import com.teamup.model.PlayerDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayersRepository extends MongoRepository<PlayerDetails,String> {
}
