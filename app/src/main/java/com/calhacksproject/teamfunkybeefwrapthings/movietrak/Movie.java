package com.calhacksproject.teamfunkybeefwrapthings.movietrak;

import android.media.Image;

import java.util.Date;

/**
 * Created by Zain on 10/4/2014.
 */
public class Movie {
    //release date
    private String releaseDateTheater;
    private String releaseDateDVD;

    //title
    private String title;
    //picture
    private String imageUrl;

    public void setDateDVD(String newDate){
        releaseDateDVD = newDate;
    }

    public void setDateTheater(String newDate){
        releaseDateDVD = newDate;
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
