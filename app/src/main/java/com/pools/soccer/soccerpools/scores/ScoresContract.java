package com.pools.soccer.soccerpools.scores;

import com.pools.soccer.soccerpools.model.Game;

import java.util.List;

/**
 * Contract used in scores fragment.
 */
public interface ScoresContract {


    /**
     * Defines the UI interactions.
     */
    interface ScoresView {

    }

    /**
     * Defines the actions that can be started from the view and if necessary it will delegate
     * the job to the interactor setting a listener that will update the view if needed.
     *
     */
    interface ScoresPresenter {

    }

    /**
     * Defines the contract for the application layer is in charge
     * of handling server calls, db access, storage, etc.
     */
    interface ScoresInteractor {

        /**
         * Retrieves a list of games for the given week number.
         * @param week
         * @return
         */
        List<Game> getGamesForWeek(int week);
    }

}
