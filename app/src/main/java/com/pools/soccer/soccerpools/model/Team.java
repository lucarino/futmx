package com.pools.soccer.soccerpools.model;

import java.io.Serializable;

/**
 * Created by lucarino on 1/13/16.
 */
public class Team implements Serializable {


    private String id;
    private String name;
    private String imageName;
    private boolean isVisitor;

    public String getName() {
        return name;
    }

    public Team(String id, String name, String imageId) {
        this.id = id;
        this.name = name;
        this.imageName = imageId;
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

    public String getImageId() {
        return imageName;
    }

    public void setImageId(String imageId) {
        this.imageName = imageId;
    }

    public boolean isVisitor() {
        return isVisitor;
    }

    public void setIsVisitor(boolean isVisitor) {
        this.isVisitor = isVisitor;
    }
}
