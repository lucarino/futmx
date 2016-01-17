package com.pools.soccer.soccerpools;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pools.soccer.soccerpools.creator.CreateMatchFragment;
import com.pools.soccer.soccerpools.service.ParseCoreManager;

public class MainActivity extends AppCompatActivity  {

    private Toolbar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);


        FragmentManager fragmentManager = getSupportFragmentManager();
        CreateMatchFragment fragment = new CreateMatchFragment();
        fragmentManager
                .beginTransaction()
                .add(R.id.main_container, fragment)
                .commit();
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
        mToolBar.setTitle(tile);
    }

}
