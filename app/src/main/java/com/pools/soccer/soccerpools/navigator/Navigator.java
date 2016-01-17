package com.pools.soccer.soccerpools.navigator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * // TODO: add optimization.
 * Class in charge of handling navigation.
 *
 * @author luis.carino
 */
public class Navigator {

    protected FragmentActivity mActivity;
    protected FragmentManager mFragmentManager;

    public Navigator(FragmentActivity activity) {
        this.mActivity = activity;
        mFragmentManager = activity.getSupportFragmentManager();
    }

    public void navigateTo(Intent targetIntent){
        mActivity.startActivity(targetIntent);
    }

    public void navigateTo(int containerViewId, Fragment targetFragment){
        // TODO: add mechanism to update the string title from the host activity toolbar
        mFragmentManager.beginTransaction()
                .replace(containerViewId, targetFragment)
                .commit();
    }

    public void startSubflow(int containerViewId, Fragment targetFragment, String tag){
        mFragmentManager.beginTransaction()
                .replace(containerViewId, targetFragment)
                .addToBackStack(tag)
                .commit();
    }

}
