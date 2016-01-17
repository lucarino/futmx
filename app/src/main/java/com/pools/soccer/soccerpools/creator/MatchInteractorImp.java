package com.pools.soccer.soccerpools.creator;

import com.pools.soccer.soccerpools.service.ParseCoreManager;

/**
 * Created by lucarino on 1/16/16.
 */
public class MatchInteractorImp implements MatchContract.Interactor {

    ParseCoreManager mParseCoreManager;

    public MatchInteractorImp(){
       mParseCoreManager  = new ParseCoreManager();
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
