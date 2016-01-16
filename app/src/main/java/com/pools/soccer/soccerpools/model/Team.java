package com.pools.soccer.soccerpools.model;

import java.io.Serializable;

/**
 * Created by lucarino on 1/13/16.
 */
public class Team implements Serializable {

    private String id;
    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public Team(String id, String name, int imageId) {
        this.id = id;
        this.name = name;
        this.imageId = imageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
