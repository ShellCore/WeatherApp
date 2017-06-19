package com.shellcore.android.weatherapp.API;

import com.shellcore.android.weatherapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Cesar on 19/06/2017.
 */

public interface WeatherInterface {

    /*@GET("weather?")
    Call<WeatherResponse> getWeatherFromZip(
            @Query("zip") String zip,
            @Query("APPID") String appId
    );*/

    @GET("{api_key}/conditions/q/Mexico/Mexico_City.json")
    Call<WeatherResponse> getWeatherFromSanFrancisco(
            @Path("api_key") String apiKey
    );
}
