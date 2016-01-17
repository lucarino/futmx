package com.pools.soccer.soccerpools.util;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.pools.soccer.soccerpools.service.GameDAO;
import com.pools.soccer.soccerpools.service.TeamDAO;

/**
 * This class holds util methods for interacting with Parse SDK.
 *
 * @author luis.carino
 */
public class ParseUtils {

    public static void registerSubclasses(Class... args) {
        // registering ParseObject subclasses.
        ParseObject.registerSubclass(GameDAO.class);
        ParseObject.registerSubclass(TeamDAO.class);

    }

    public static void init(Application context){
        Parse.initialize(context);
    }
}
