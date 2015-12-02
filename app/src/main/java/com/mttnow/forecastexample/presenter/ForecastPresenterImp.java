package com.mttnow.forecastexample.presenter;

import android.content.Context;
import android.widget.Toast;

import com.mttnow.forecastexample.MainActivity;
import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.api.ApiGenerator;
import com.mttnow.forecastexample.api.ForecastApi;
import com.mttnow.forecastexample.entites.Forecast;
import com.mttnow.forecastexample.view.ForecastView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by alahammad on 12/2/15.
 */
public class ForecastPresenterImp implements ForecastPresenter {


    private ForecastView forecastView;


    public ForecastPresenterImp(ForecastView forecastView) {
        this.forecastView = forecastView;
    }

    @Override
    public void loadForecast(String country, final Context context) {
        forecastView.startLoading();
        ForecastApi retrofit = ApiGenerator.createService(ForecastApi.class);
        Call<Forecast> call = retrofit.getForecast(country, "json", context.getString(R.string.api_key));
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Response<Forecast> response, Retrofit retrofit) {
                forecastView.stopLoading();
                if (response.isSuccess()) {
                    String weather = response.body().getData().getWeather()[0].getMaxtempC();
                    Toast.makeText(context, "Temp : " + weather, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                forecastView.stopLoading();
            }
        });
    }
}
