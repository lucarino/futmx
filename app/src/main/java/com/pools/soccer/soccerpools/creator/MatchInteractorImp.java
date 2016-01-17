package com.pools.soccer.soccerpools.creator;

import com.pools.soccer.soccerpools.application.SoccerPoolsApplication;
import com.pools.soccer.soccerpools.service.ParseCoreManager;

import javax.inject.Inject;

/**
 * Concrete interactor implementation.
 *
 * @author luis.carino
 */
public class MatchInteractorImp implements MatchContract.Interactor {

    ParseCoreManager mParseCoreManager;

    @Inject
    public MatchInteractorImp(ParseCoreManager parseCoreManager) {
        SoccerPoolsApplication.getApplicationComponent().inject(this);
        mParseCoreManager = parseCoreManager;
    }

    @Override
    public void fetchAllTeams() {
        mParseCoreManager.getAllTeams();
    }

    @Override
    public void createGame(String homeId, String visitorId) {
        mParseCoreManager.createGame(homeId, visitorId);
    }
}
