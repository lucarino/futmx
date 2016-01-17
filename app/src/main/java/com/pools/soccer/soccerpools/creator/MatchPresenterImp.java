package com.pools.soccer.soccerpools.creator;

import com.pools.soccer.soccerpools.service.ParseCoreManager;
import com.pools.soccer.soccerpools.util.OttoHelper;
import com.squareup.otto.Subscribe;

import org.apache.commons.collections4.CollectionUtils;

/**
 * Concrete implementation for presenter in create feature.
 *
 * @author luis.carino
 */
public class MatchPresenterImp implements MatchContract.Presenter {

    private MatchContract.Interactor mInteractor;
    private MatchContract.View mView;


    public MatchPresenterImp(MatchContract.View mView) {
        this.mView = mView;
        mInteractor = new MatchInteractorImp();
        OttoHelper.getInstance().register(this);
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

        if (event.isSuccess() && !CollectionUtils.isEmpty(event.getTeams())) {
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
