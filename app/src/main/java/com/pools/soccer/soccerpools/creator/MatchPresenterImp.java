package com.pools.soccer.soccerpools.creator;

import com.pools.soccer.soccerpools.application.SoccerPoolsApplication;
import com.pools.soccer.soccerpools.service.ParseCoreManager;
import com.pools.soccer.soccerpools.util.OttoBus;
import com.squareup.otto.Subscribe;


import javax.inject.Inject;

/**
 * Concrete implementation for presenter in create feature.
 *
 * @author luis.carino
 */
public class MatchPresenterImp implements MatchContract.Presenter {

    @Inject
    MatchContract.Interactor mInteractor;
    private MatchContract.View mView;

    @Inject
    OttoBus mBus;


    @Inject
    public MatchPresenterImp(MatchContract.View mView) {
        SoccerPoolsApplication.getApplicationComponent().inject(this);
        this.mView = mView;
        mBus.register(this);
    }

    @Override
    public void getAllTeams() {
        mInteractor.fetchAllTeams();
    }


    @Override
    public void createNewGame(String homeId, String visitorId) {
        mInteractor.createGame(homeId, visitorId);
    }

    /////////////////////// Event bus subscriptions callbacks from interactor////////////////////////////
    @Subscribe
    public void onTeamsFeched(ParseCoreManager.TeamResultEvent event) {

        if (event.isSuccess() && event.getTeams() != null && !event.getTeams().isEmpty()) {
            mView.setTeamsToAdapter(event.getTeams());
        }

    }


    @Subscribe
    public void onMatchCreated(ParseCoreManager.CreateMatchEvent event){
        if(event.isSuccess()){
            mView.onGameCreated();
        }
    }

}
