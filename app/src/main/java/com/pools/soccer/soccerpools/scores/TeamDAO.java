package com.pools.soccer.soccerpools.scores;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.pools.soccer.soccerpools.model.Team;

/**
 * Created by lucarino on 1/14/16.
 */
@ParseClassName("Team")
public class TeamDAO extends ParseObject {

    private final String ID_COL = "objectId";
    private final String NAME_COL = "name";
    private final String IMAGE_ID_COL = "imageId";

    public TeamDAO() {
    }

    public void setName(String name){
        put(NAME_COL, name);
    }

    public void setImageId(int imageId){
        put(IMAGE_ID_COL, imageId);
    }
    
    public String getName(){
        return getString(NAME_COL);
    }

    public int getImageId(){
        return getInt(IMAGE_ID_COL);
    }

    public String getId(){
        return getString(ID_COL);
    }

}
