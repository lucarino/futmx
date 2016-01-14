package com.pools.soccer.soccerpools.model;

import java.io.Serializable;

/**
 * Created by lucarino on 1/13/16.
 */
public class Score implements Serializable {

    private int homeGoals;
    private int guestGoals;

    public Score(int homeGoals, int guestGoals) {
        this.homeGoals = homeGoals;
        this.guestGoals = guestGoals;
    }


    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getGuestGoals() {
        return guestGoals;
    }

    public void setGuestGoals(int guestGoals) {
        this.guestGoals = guestGoals;
    }

}


