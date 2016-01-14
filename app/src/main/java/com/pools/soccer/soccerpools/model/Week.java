package com.pools.soccer.soccerpools.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Model class that represents a week.
 *
 */
public class Week implements Serializable {

    List<Game> games;
    Date date;

    public Week() {
        super();
    }

    public Week(List<Game> games, Date date) {
        this.games = games;
        this.date = date;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
