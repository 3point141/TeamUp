package com.teamup.model;

public class TeamDetails {

    private int numberOfPlayers;
    private int numberOfTeams;

    public TeamDetails(){}

    public TeamDetails(int numberOfPlayers, int numberOfTeams) {
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfTeams = numberOfTeams;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    @Override
    public String toString() {
        return "TeamDetails{" +
                "numberOfPlayers=" + numberOfPlayers +
                ", numberOfTeams=" + numberOfTeams +
                '}';
    }
}
