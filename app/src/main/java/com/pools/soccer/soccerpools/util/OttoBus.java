package com.pools.soccer.soccerpools.util;

import com.squareup.otto.Bus;

/**
 * Class in charge of handling bus interactions.
 *
 * @author luis.carino
 */
public class OttoBus {

    private Bus mOttoBus;

    public OttoBus() {
        mOttoBus = new Bus();
    }

    public Bus getBus() {
        return mOttoBus;
    }

    public void post(Object event) {
        mOttoBus.post(event);
    }

    public void register(Object object) {
        mOttoBus.register(object);
    }

    public void unregister(Object event) {
        mOttoBus.unregister(event);
    }


}
