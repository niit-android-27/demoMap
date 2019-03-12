package com.luan.session10_view.demomapniit;


import com.google.gson.annotations.SerializedName;

public class StateModel {
    @SerializedName("state")
    String state;

    @SerializedName("latitude")
    float lat;

    @SerializedName("longitude")
    float lng;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
