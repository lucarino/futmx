package com.pools.soccer.soccerpools.service;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.pools.soccer.soccerpools.model.Team;

/**
 * @author luis.carino
 */
@ParseClassName("Team")
public class TeamDAO extends ParseObject {

    public static final String ID_COL = "objectId";
    public static final String NAME_COL = "name";
    private final String IMAGE_ID_COL = "image";

    public TeamDAO() {
    }

    public void setName(String name){
        put(NAME_COL, name);
    }

    public void setImageId(String imageId){
        put(IMAGE_ID_COL, imageId);
    }
    
    public String getName(){
        return getString(NAME_COL);
    }

    public String getImageId(){
        return getString(IMAGE_ID_COL);
    }


}
