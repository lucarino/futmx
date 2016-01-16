package com.pools.soccer.soccerpools.game.creator;

import com.pools.soccer.soccerpools.model.Team;

import java.util.List;

/**
 * Defines the MVP contract for the creator feature.
 *
 * @author luis.carino
 */
public interface GameCreatorContract {

    interface View {
        void setTeamsToSpinner(List<Team> teams);
    }

    interface Presenter {
        void getAllTeams();
    }

    interface Interactor {
        void fetchAllTeams();
    }
}
