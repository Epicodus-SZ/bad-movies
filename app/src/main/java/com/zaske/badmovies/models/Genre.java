package com.zaske.badmovies.models;

/**
 * Created by Guest on 9/13/17.
 */

public class Genre {
    private String mName;
    private int mID;

    public  Genre(String name, int id){
        this.mName = name;
        this.mID = id;
    }

    public String getName(){
        return mName;
    }

    public int getID(){
        return mID;
    }
}
