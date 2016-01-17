package com.pools.soccer.soccerpools.application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.pools.soccer.soccerpools.service.GameDAO;
import com.pools.soccer.soccerpools.service.TeamDAO;
import com.pools.soccer.soccerpools.util.ParseUtils;

/**
 * Main application object.
 *
 * @author luis.carino
 */
public class SoccerPoolsApplication extends Application {

    private static AppComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // builds graph used for dependency injection.
        mApplicationComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        // set up parse.
        ParseUtils.registerSubclasses(TeamDAO.class, GameDAO.class);
        ParseUtils.init(this);
    }

    public static AppComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
