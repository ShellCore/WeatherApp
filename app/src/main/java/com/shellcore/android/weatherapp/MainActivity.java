package com.shellcore.android.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.shellcore.android.weatherapp.model.WeatherData;
import com.shellcore.android.weatherapp.model.WeatherResponse;
import com.shellcore.android.weatherapp.task.WeatherTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WeatherTask.WeatherListener {

    // Constants
    public static final String BASE_URL = "http://api.wunderground.com/api/";
    public static final String API_KEY = "71a068bb14405eda";

    // Components
    @BindView(R.id.pressure)
    TextView pressure;
    @BindView(R.id.countryName)
    TextView countryName;
    @BindView(R.id.temperature)
    TextView temperature;
    @BindView(R.id.humidity)
    TextView humidity;
    @BindView(R.id.weather)
    TextView weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        WeatherTask task = new WeatherTask(this, this);
        task.execute(BASE_URL, API_KEY);
    }

    @Override
    public void handleResult(WeatherResponse response) {
        WeatherData data = response.getWeatherData();
        countryName.setText(data.getDisplayLocation().getCityName());
        weather.setText(data.getWeather());
        temperature.setText(data.getTemp());
        pressure.setText(data.getPressure());
        humidity.setText(data.getHumidity());
    }
}
