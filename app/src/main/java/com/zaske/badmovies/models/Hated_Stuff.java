package com.zaske.badmovies.models;

/**
 * Created by Guest on 9/14/17.
 */

public class Hated_Stuff {
    private int mID;
    private String mName;
    private String mReason;
    private String mImgUrl;
    private int mHateLevel;


    public Hated_Stuff (int id, String name, String reason, String imgUrl, int hateLevel ){
        this.mID = id;
        this.mName = name;
        this.mReason = reason;
        this.mImgUrl = imgUrl;
        this.mHateLevel = hateLevel;
    }

    public String getName(){
        return mName;
    }

    public int getID(){
        return mID;
    }

    public String getReason(){
        return mReason;
    }

    public String getImgUrl(){
        return mImgUrl;
    }

    public int getHateLevel(){
        return mHateLevel;
    }

}
