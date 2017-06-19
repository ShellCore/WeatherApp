package com.shellcore.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cesar on 19/06/2017.
 */

public class WeatherResponse {

    @SerializedName("current_observation")
    private WeatherData weatherData;

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
