package com.pools.soccer.soccerpools.navigator;

/**
 * Abstract class used to set the contract for navigator objects.
 *
 * @author luis.carino
 */
public abstract class NavigatorEntry<Navigator> {

    protected Navigator mNavigator;

    public NavigatorEntry(Navigator mNavigator) {
        this.mNavigator = mNavigator;
    }

    public abstract void navigate();

}
