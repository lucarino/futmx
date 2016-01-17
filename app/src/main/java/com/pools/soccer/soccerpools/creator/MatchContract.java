package com.pools.soccer.soccerpools.creator;

import com.pools.soccer.soccerpools.model.Team;

import java.util.List;

/**
 * Defines the MVP contract for the creator feature.
 *
 * @author luis.carino
 */
public interface MatchContract {

    interface View {
        void setTeamsToAdapter(List<Team> teams);
        void onGameCreated();
    }

    interface Presenter {
        void getAllTeams();
        void createNewGame(String homeId, String visitorId);
    }

    interface Interactor {
        void fetchAllTeams();
        void createGame(String homeId, String visitorId);
    }

}
