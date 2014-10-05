package com.calhacksproject.teamfunkybeefwrapthings.movietrak;

import android.media.Image;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zain on 10/4/2014.
 */
public class Movie implements Serializable{
    //release date
    private String releaseDateTheater;
    private String releaseDateDVD;

    //title
    private String title;
    //picture
    private String imageUrl;

    public void setDateDVD(String newDate){
        if(newDate == null){
            releaseDateDVD = "Unknown release date";
            return;
        }
        releaseDateDVD = newDate;
    }

    public void setDateTheater(String newDate){
        if(newDate == null){
            releaseDateTheater = "Unknown release date";
            return;
        }
        releaseDateTheater = newDate;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateDVD() {
        return releaseDateDVD;
    }

    public String getDateTheater() {
        return releaseDateTheater;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
}
