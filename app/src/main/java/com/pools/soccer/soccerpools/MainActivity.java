package com.pools.soccer.soccerpools;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.pools.soccer.soccerpools.commons.BaseActivity;
import com.pools.soccer.soccerpools.creator.CreateMatchFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main);

        CreateMatchFragment fragment = new CreateMatchFragment();
        setToolbarTile(fragment.getToolbarTitle());
        mNavigator.navigateTo(R.id.main_container, fragment);

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


}
