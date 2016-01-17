package com.pools.soccer.soccerpools.application;

import android.content.Context;

import com.pools.soccer.soccerpools.creator.MatchContract;
import com.pools.soccer.soccerpools.creator.MatchInteractorImp;
import com.pools.soccer.soccerpools.creator.MatchPresenterImp;
import com.pools.soccer.soccerpools.service.ParseCoreManager;
import com.pools.soccer.soccerpools.util.OttoBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Main application module used to provide app-specific components.
 *
 * @author luis.carino
 */

@Module
public class AppModule {

    private final SoccerPoolsApplication mApplication;

    public AppModule(SoccerPoolsApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    public OttoBus provideEventBus(){
        return new OttoBus();
    }

    @Singleton
    @Provides
    public ParseCoreManager provideParseCoreManager() {
        return new ParseCoreManager();
    }

    @Singleton
    @Provides
    public MatchContract.Interactor providesMatchInteractor(ParseCoreManager parseCoreManager){
        return new MatchInteractorImp(parseCoreManager);
    }

    @Singleton
    @Provides
    public MatchContract.Presenter providesMatchPresent(MatchContract.View mView){
        return new MatchPresenterImp(mView);
    }

}
