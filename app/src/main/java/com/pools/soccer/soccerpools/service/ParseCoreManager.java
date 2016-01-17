package com.pools.soccer.soccerpools.service;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.pools.soccer.soccerpools.application.SoccerPoolsApplication;
import com.pools.soccer.soccerpools.model.Game;
import com.pools.soccer.soccerpools.model.Team;
import com.pools.soccer.soccerpools.util.OttoBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Manager for interaction with  Parse Core.
 */
public class ParseCoreManager {

    private final String TAG = this.getClass().getSimpleName();
    private GameDAO mGameDAO;

    @Inject
    OttoBus mBus;

    public ParseCoreManager() {
        SoccerPoolsApplication.getApplicationComponent().inject(this);
        mGameDAO = new GameDAO();
        mBus.register(this);
    }

    public List<Game> retireveGames(int week) {


        return null;
    }


    /**
     * Creates a new {@link Game} object in the core cloud.
     *
     * @return
     */

    public void createGame(final String home, final String visitor) {

        List<String> ids = new ArrayList<>();
        ids.add(home);
        ids.add(visitor);
        // make the request to get the team objects stored in the cloud core.
        ParseQuery<TeamDAO> queryTeamsForMatch = ParseQuery.getQuery("Team");
        queryTeamsForMatch.whereContainedIn(TeamDAO.ID_COL, ids);
        queryTeamsForMatch.findInBackground(new FindCallback<TeamDAO>() {
            @Override
            public void done(List<TeamDAO> objects, ParseException e) {
                if (objects != null && !objects.isEmpty() && e == null) {
                    // check for home and visitor
                    if (objects.get(0).getObjectId().equals(home)) {
                        mGameDAO.setHome(objects.get(0));
                        mGameDAO.setGuest(objects.get(1));
                    } else {
                        mGameDAO.setHome(objects.get(1));
                        mGameDAO.setGuest(objects.get(0));
                    }
                    mGameDAO.saveInBackground(new SaveCallback() {
                        CreateMatchEvent event = new CreateMatchEvent();

                        @Override
                        public void done(ParseException e) {
                            if (e != null) {
                                event.setIsSuccess(false);
                                Log.d(TAG, "something bad happened when creating match " + e.getMessage());
                            } else {
                                event.setIsSuccess(true);
                                mBus.post(event);
                            }
                        }
                    });

                    Log.d(TAG, "Teams for match: " + objects.toString());
                } else {
                    Log.d(TAG, "something bad happened when fetching teams for match creation.");
                }

            }
        });

    }


    public void getAllTeams() {
        ParseQuery<TeamDAO> query = ParseQuery.getQuery("Team");
        query.orderByAscending(TeamDAO.NAME_COL);
        query.findInBackground(new FindCallback<TeamDAO>() {
            @Override
            public void done(List<TeamDAO> teams, ParseException e) {

                TeamResultEvent teamResultEvent = new TeamResultEvent();
                if (teams != null && !teams.isEmpty() && e == null) {
                    teamResultEvent.setIsSuccess(true);
                    teamResultEvent.setTeams(teams);
                    Log.d(TAG, String.format("Response from fetching teams %s", teams.toString()));
                } else {
                    // something bad happened.
                    teamResultEvent.setIsSuccess(false);
                    Log.d(TAG, String.format("Something bad happen when fetching teams error: %s", e.getMessage()));
                }

                mBus.post(teamResultEvent);
            }
        });
    }


    /**
     * Base Event class for otto events.
     */
    public static class OttoEvent {
        private boolean isSuccess;

        public boolean isSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }

    }

    /**
     * DTO for team result events.
     */
    public static class TeamResultEvent extends OttoEvent {
        private boolean isSuccess;
        private List<Team> teams;

        public List<Team> getTeams() {
            return teams;
        }


        /**
         * Decouples the DAO used to manipulate the cloud data to a POJO.
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

    public static class CreateMatchEvent extends OttoEvent {

    }


}
