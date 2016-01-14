package com.pools.soccer.soccerpools.model;

import java.io.Serializable;

/**
 * Created by lucarino on 1/13/16.
 */
public class Bet implements Serializable {
    private  boolean home;
    private  boolean guest;
    private  boolean tie;


    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }

    public boolean isTie() {
        return tie;
    }

    public void setTie(boolean tie) {
        this.tie = tie;
    }
}
