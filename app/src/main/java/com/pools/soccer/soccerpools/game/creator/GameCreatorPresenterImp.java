package com.pools.soccer.soccerpools.game.creator;

import com.pools.soccer.soccerpools.service.ParseCoreManager;
import com.pools.soccer.soccerpools.util.OttoHelper;
import com.squareup.otto.Subscribe;

import org.apache.commons.collections4.CollectionUtils;

/**
 * Concrete implementation for presenter in create feature.
 *
 * @author luis.carino
 */
public class GameCreatorPresenterImp implements GameCreatorContract.Presenter {

    private GameCreatorContract.Interactor mInteractor;
    private GameCreatorContract.View mView;


    public GameCreatorPresenterImp(GameCreatorContract.View mView) {
        this.mView = mView;
        mInteractor = new GameCreatorInteractorImp();
        OttoHelper.getInstance().register(this);
    }

    @Override
    public void getAllTeams() {
        mInteractor.fetchAllTeams();
    }


    /////////////////////// Event bus subscriptions callbacks from interactor////////////////////////////
    @Subscribe
    public void onTeamsFeched(ParseCoreManager.TeamResultEvent event) {

        if (event.isSuccess() && !CollectionUtils.isEmpty(event.getTeams())) {
            mView.setTeamsToSpinner(event.getTeams());
        }

    }
}
