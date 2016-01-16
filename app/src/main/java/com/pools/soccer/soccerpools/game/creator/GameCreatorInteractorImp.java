package com.pools.soccer.soccerpools.game.creator;

import com.pools.soccer.soccerpools.service.ParseCoreManager;

/**
 * Created by lucarino on 1/16/16.
 */
public class GameCreatorInteractorImp implements GameCreatorContract.Interactor {

    ParseCoreManager mParseCoreManager;

    public GameCreatorInteractorImp(){
       mParseCoreManager  = new ParseCoreManager();
    }

    @Override
    public void fetchAllTeams() {
        mParseCoreManager.getAllTeams();
    }



}
