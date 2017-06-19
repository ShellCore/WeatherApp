package com.shellcore.android.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shellcore.android.weatherapp.API.WeatherInterface;
import com.shellcore.android.weatherapp.model.WeatherResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://api.wunderground.com/api/";
    public static final String API_KEY = ""; // TODO PASTE HERE YOUR API KEY

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*********** TODO: MOVE THIS BLOCK OF CODE TO AN ASYNC_TASK ***********
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);
        Call<WeatherResponse> call = weatherInterface.getWeatherFromSanFrancisco(API_KEY);
        WeatherResponse response = null;

        try {
            response = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //**********************************************************************
    }
}
