package com.pools.soccer.soccerpools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pools.soccer.soccerpools.application.SoccerPoolsApplication;
import com.pools.soccer.soccerpools.creator.CreateMatchFragment;
import com.pools.soccer.soccerpools.navigator.Navigator;
import com.pools.soccer.soccerpools.util.OttoBus;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    protected Navigator mNavigator;

    @Inject
    OttoBus mBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoccerPoolsApplication.getApplicationComponent().inject(this);
        // init objects
        mBus.register(this);
        mNavigator = new Navigator(this);


        CreateMatchFragment fragment = new CreateMatchFragment();
        mNavigator.navigateTo(R.id.main_container, fragment);


        setToolbarTile(fragment.getToolbarTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void setToolbarTile(final String tile) {
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setTitle(tile);
    }

}
