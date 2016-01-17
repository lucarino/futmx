package com.pools.soccer.soccerpools.application;

import android.content.Context;

import com.pools.soccer.soccerpools.MainActivity;
import com.pools.soccer.soccerpools.creator.CreateMatchFragment;
import com.pools.soccer.soccerpools.creator.MatchInteractorImp;
import com.pools.soccer.soccerpools.creator.MatchPresenterImp;
import com.pools.soccer.soccerpools.creator.TeamRecyclerViewAdapter;
import com.pools.soccer.soccerpools.service.ParseCoreManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Main app module - works as a bridge between  modules annotations.
 *
 * @author luis.carino
 */
@Singleton
 @Component(modules = {AppModule.class})
public interface AppComponent {

    // define functions to inject specific type objects
    void inject(MainActivity activity);
    void inject(CreateMatchFragment fragment);
    void inject(MatchPresenterImp presenterImp);
    void inject(MatchInteractorImp interactorImp);
    void inject(ParseCoreManager parseCoreManager);
    void inject(TeamRecyclerViewAdapter adapter);

    // expose injectable objects to sub-graphs.
    Context context();

}
