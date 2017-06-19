package com.shellcore.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cesar on 19/06/2017.
 */

public class DisplayLocation {

    @SerializedName("city")
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
