package com.example.rajasthantouristguideapp;

public class Visit {

    private String Cityname;
    private int image;

    public Visit(String cityname, int image) {
        Cityname = cityname;
        this.image = image;
    }
    public String getCityname() {
        return Cityname;
    }
    public int getImage() {
        return image;
    }

}
