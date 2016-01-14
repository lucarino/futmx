package com.pools.soccer.soccerpools.application;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by lucarino on 1/13/16.
 */
public class SoccerPoolsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this);
    }
}
