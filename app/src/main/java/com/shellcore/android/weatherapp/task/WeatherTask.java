package com.shellcore.android.weatherapp.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.shellcore.android.weatherapp.API.WeatherInterface;
import com.shellcore.android.weatherapp.model.WeatherResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Cesar on 19/06/2017.
 */

public class WeatherTask extends AsyncTask<String, Void, WeatherResponse> {

    private ProgressDialog progressDialog;
    private WeatherListener listener;

    public WeatherTask(Context context, WeatherListener listener) {
        progressDialog = new ProgressDialog(context);
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Updating data...");
        progressDialog.show();
    }

    @Override
    protected WeatherResponse doInBackground(String... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(params[0])
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);
        Call<WeatherResponse> call = weatherInterface.getWeatherFromSanFrancisco(params[1]);
        WeatherResponse response = null;

        try {
            response = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(WeatherResponse weatherResponse) {
        super.onPostExecute(weatherResponse);
        progressDialog.dismiss();
        listener.handleResult(weatherResponse);
    }

    public interface WeatherListener {
        void handleResult(WeatherResponse response);
    }
}
