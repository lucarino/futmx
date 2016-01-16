package com.pools.soccer.soccerpools.scores;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.pools.soccer.soccerpools.model.Bet;
import com.pools.soccer.soccerpools.model.Score;
import com.pools.soccer.soccerpools.model.Team;

/**
 * Created by lucarino on 1/14/16.
 */

@ParseClassName("Game")
public class GameDAO extends ParseObject {

    private String GAMES_ID_COL_NAME = "objectId";
    private String GAMES_HOME_COL_NAME = "home";
    private String GAMES_GUEST_COL_NAME = "guest";
    private String GAMES_SCORE_COL_NAME = "score";
    private String GAMES_BET_COL_NAME = "bet";

    public GameDAO() {
    }

    public String getHome() {
        return getString(GAMES_HOME_COL_NAME);
    }

    public String getGuest() {
        return getString(GAMES_GUEST_COL_NAME);
    }

    public Object getScore() {
        return get(GAMES_SCORE_COL_NAME);
    }

    public Object getBet() {
        return get(GAMES_BET_COL_NAME);
    }

    public void setHome(TeamDAO home) {
        put(GAMES_HOME_COL_NAME, home);
    }

    public void setHome(String home) {
        put(GAMES_HOME_COL_NAME, home);
    }

    public void setGuest(TeamDAO guest) {
        put(GAMES_GUEST_COL_NAME, guest);
    }

    public void setGuest(String guest) {
        put(GAMES_GUEST_COL_NAME, guest);
    }

    public void setScore(Score score) {
        put(GAMES_SCORE_COL_NAME, score);
    }

    public void setScore(String score) {
        put(GAMES_SCORE_COL_NAME, score);
    }

    public void setBet(String bet) {
        put(GAMES_BET_COL_NAME, bet);
    }

    public String getId(String id){
        return getString(GAMES_ID_COL_NAME);
    }

}
