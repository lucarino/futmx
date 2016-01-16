package com.pools.soccer.soccerpools.service;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.pools.soccer.soccerpools.model.Game;
import com.pools.soccer.soccerpools.model.Team;
import com.pools.soccer.soccerpools.scores.GameDAO;
import com.pools.soccer.soccerpools.scores.TeamDAO;
import com.pools.soccer.soccerpools.util.OttoHelper;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager for interaction with  Parse Core.
 */
public class ParseCoreManager {

    private final String TAG = this.getClass().getSimpleName();
    private GameDAO mGameDAO;

    public ParseCoreManager() {
        OttoHelper.getInstance().register(this);
        mGameDAO = new GameDAO();
    }

    public List<Game> retireveGames(int week) {


        return null;
    }


    /**
     * Creates a new {@link Game} object in the core cloud.
     *
     * @return
     */
    public void createGame(GameDAO game) {
        mGameDAO.setHome(game.getHome());
        mGameDAO.setGuest(game.getGuest());
        mGameDAO.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });
    }

    public void createGame(String home, String guest) {
        mGameDAO.setHome(home);
        mGameDAO.setGuest(guest);
        mGameDAO.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.d("TAG", e.getMessage());
            }
        });
    }


    public void getAllTeams() {
        ParseQuery<TeamDAO> query = ParseQuery.getQuery("Team");
        query.findInBackground(new FindCallback<TeamDAO>() {
            @Override
            public void done(List<TeamDAO> teams, ParseException e) {

                TeamResultEvent teamResultEvent = new TeamResultEvent();
                if (!CollectionUtils.isEmpty(teams) && e == null) {
                    teamResultEvent.setIsSuccess(true);
                    teamResultEvent.setTeams(teams);
                    Log.d(TAG, String.format("Response from fetching teams %s", teams.toString()));
                } else {
                    // something bad happened.
                    teamResultEvent.setIsSuccess(false);
                    Log.d(TAG, String.format("Something bad happen when fetching teams error: %s", e.getMessage()));
                }

                OttoHelper.getInstance().post(teamResultEvent);
            }
        });
    }


    /**
     * DTO for team result events.
     */
    public static class TeamResultEvent {
        private boolean isSuccess;
        private List<Team> teams;

        public List<Team> getTeams() {
            return teams;
        }

        public boolean isSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }

        /**
         * Decouples the DAO retrieved from the server to the model.
         *
         * @param teamsDAO
         */
        public void setTeams(List<TeamDAO> teamsDAO) {
            teams = new ArrayList<>();
            for (TeamDAO team : teamsDAO) {
                teams.add(new Team(team.getObjectId(), team.getName(), team.getImageId()));
            }

        }
    }


}
