package com.shellcore.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cesar on 19/06/2017.
 */

public class WeatherData {

    @SerializedName("relative_humidity")
    private String humidity;
    @SerializedName("pressure_mb")
    private String pressure;
    @SerializedName("temperature_string")
    private String temp;
    @SerializedName("weather")
    private String weather;
    @SerializedName("display_location")
    private DisplayLocation displayLocation;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public DisplayLocation getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(DisplayLocation displayLocation) {
        this.displayLocation = displayLocation;
    }
}
