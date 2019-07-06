package com.teamup.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class PlayerDetails {

    @Id
    private String playerName;
    private int playerRating;

    public PlayerDetails(){}

    public PlayerDetails(String playerName, int playerRating) {
        this.playerName = playerName;
        this.playerRating = playerRating;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(int playerRating) {
        this.playerRating = playerRating;
    }

    @Override
    public String toString() {
        return "PlayerDetails{" +
                "playerName='" + playerName + '\'' +
                ", playerRating=" + playerRating +
                '}';
    }
}
