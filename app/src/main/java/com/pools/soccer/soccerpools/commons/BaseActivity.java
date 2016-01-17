package com.pools.soccer.soccerpools.commons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.pools.soccer.soccerpools.R;
import com.pools.soccer.soccerpools.application.SoccerPoolsApplication;
import com.pools.soccer.soccerpools.navigator.Navigator;
import com.pools.soccer.soccerpools.util.OttoBus;

import javax.inject.Inject;

/**
 * @author luis.carino
 */
public class BaseActivity extends AppCompatActivity {

    @Inject
    OttoBus mBus;
    protected Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SoccerPoolsApplication.getApplicationComponent().inject(this);
        // init objects
        mBus.register(this);
        mNavigator = new Navigator(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mBus.unregister(this);
    }

    protected void setToolbarTile(final String tile) {
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setTitle(tile);
    }

    protected void setLayout(int layoutId) {
        setContentView(layoutId);
    }


}
