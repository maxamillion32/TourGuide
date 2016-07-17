package com.example.android.tourguide;

/**
 * Created by Matt on 7/12/2016.
 */
public class Location {
    private String name;
    private static final String NO_STRING = "";
    private String subname = NO_STRING;
    private String hours = NO_STRING;
    private String address = NO_STRING;
    private static final int NO_IMAGE = -1;
    private int imResId = NO_IMAGE;

    public Location(String name, String subname, String hours, String address) {
        this.name = name;
        this.subname = wrapParenSubname(subname);
        this.hours = hours;
        this.address = address;
    }

    public Location(int imResId, String name) {
        this.imResId = imResId;
        this.name = name;
    }

    private String wrapParenSubname(String subname){
        if(subname.equals("")) return subname;
        return "(" + subname + ")";
    }

    public int getImageResourceId() {
        return imResId;
    }

    public String getName() {
        return name;
    }

    public String getSubname() {
        return subname;
    }

    public String getHours() {
        return hours;
    }

    public String getAddress() { return address; }

    public boolean hasImage() {
        return imResId != NO_IMAGE;
    }
}
