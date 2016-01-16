package com.pools.soccer.soccerpools.model;

import com.parse.ParseObject;

import java.io.Serializable;

/**
 * Created by lucarino on 1/13/16.
 */
public class Game implements Serializable {

    private String id;
    private Team home;
    private Team guest;
    private Score score;
    private Bet bet;

    public Game() {
    }

    public Game(Team home, Team guest, Score score, Bet guessing) {
        this.home = home;
        this.guest = guest;
        this.score = score;
        this.bet = guessing;
    }

    public Game(Team home, Team guest, Score score) {
        this.home = home;
        this.guest = guest;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getGuest() {
        return guest;
    }

    public void setGuest(Team guest) {
        this.guest = guest;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
