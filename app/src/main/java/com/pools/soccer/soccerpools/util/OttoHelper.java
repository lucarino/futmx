package com.pools.soccer.soccerpools.util;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Singleton used for Otto bus.
 * TODO: remove this class when dagger gets integrated.
 */
public class OttoHelper {

    private static OttoHelper mInstance;
    private Bus mOttoBus;

    private OttoHelper(){
        mOttoBus = new Bus();
    }

    public synchronized static OttoHelper getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new OttoHelper();
        }
        return mInstance;
    }

    public Bus getBus(){
        return mOttoBus;
    }

    public void post(Object event){
        mOttoBus.post(event);
    }

    public void register(Object object){
        mOttoBus.register(object);
    }

    public void unregister(Object event){
        mOttoBus.unregister(event);
    }





}
