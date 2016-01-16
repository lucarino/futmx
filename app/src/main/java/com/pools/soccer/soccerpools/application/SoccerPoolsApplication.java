package com.pools.soccer.soccerpools.application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.pools.soccer.soccerpools.scores.GameDAO;
import com.pools.soccer.soccerpools.scores.TeamDAO;

/**
 * Created by lucarino on 1/13/16.
 */
public class SoccerPoolsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // registering ParseObject subclasses.
        ParseObject.registerSubclass(GameDAO.class);
        ParseObject.registerSubclass(TeamDAO.class);
        Parse.initialize(this);
    }
}
