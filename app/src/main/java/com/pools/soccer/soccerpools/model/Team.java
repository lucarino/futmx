package com.pools.soccer.soccerpools.model;

import java.io.Serializable;

/**
 * Created by lucarino on 1/13/16.
 */
public class Team implements Serializable {

    private String name;
    private String imageId;

    public String getName() {
        return name;
    }

    public Team(String name, String imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
