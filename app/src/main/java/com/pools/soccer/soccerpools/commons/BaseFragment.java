package com.pools.soccer.soccerpools.commons;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.pools.soccer.soccerpools.application.SoccerPoolsApplication;
import com.pools.soccer.soccerpools.util.OttoBus;

import javax.inject.Inject;

/**
 * @author luis.carino
 */
public class BaseFragment extends Fragment {

    @Inject
    OttoBus mBus;
    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
        // resolve dependency injections
        SoccerPoolsApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mBus.unregister(this);
    }
}
