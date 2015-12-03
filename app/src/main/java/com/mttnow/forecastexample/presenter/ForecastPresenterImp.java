package com.mttnow.forecastexample.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.adapters.CitiesAdapter;
import com.mttnow.forecastexample.adapters.RealmCitiesAdapter;
import com.mttnow.forecastexample.api.ApiGenerator;
import com.mttnow.forecastexample.api.ForecastApi;
import com.mttnow.forecastexample.entites.*;
import com.mttnow.forecastexample.entites.Error;
import com.mttnow.forecastexample.utils.DatabaseUtils;
import com.mttnow.forecastexample.utils.DialogsUtils;
import com.mttnow.forecastexample.utils.Utils;
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
    public void loadForecast(final String country, final Context context, final CitiesAdapter adapter) {
        forecastView.startLoading();
        ForecastApi retrofit = ApiGenerator.createService(ForecastApi.class);
        Call<Forecast> call = retrofit.getForecast(country, context.getString(R.string.api_key));

        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Response<Forecast> response, Retrofit retrofit) {
                forecastView.stopLoading();
                if (response.isSuccess() && TextUtils.isEmpty(response.body().getData().getError().get(0).getMsg())) {
                    String temp = response.body().getData().getWeather().get(0).getMaxtempC();
                    City city = new City(country, temp);
                    DatabaseUtils.getInstance(context).create(city);
                    adapter.notifyDataSetChanged();
                } else {
                    DialogsUtils.getInstance().showDialog(context, response.body().getData().getError().get(0).getMsg());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogsUtils.getInstance().showDialog(context, "Error");
                forecastView.stopLoading();
            }
        });
    }

    @Override
    public void loadForecasts(final Context context, final CitiesAdapter adapter) {
        forecastView.startLoading();
        ForecastApi retrofit = ApiGenerator.createService(ForecastApi.class);
        for (int i = 0; i < adapter.getItemCount(); i++) {
            final int index = i;
            Call<Forecast> call = retrofit.getForecast(adapter.getItem(i).getRequest().get(0).getQuery(), context.getString(R.string.api_key));
            call.enqueue(new Callback<Forecast>() {
                @Override
                public void onResponse(Response<Forecast> response, Retrofit retrofit) {
                    forecastView.stopLoading();
                    if (response.isSuccess()) {
//                        City city = adapter.getItem(index);
//                            DatabaseUtils.getInstance(context).createData(response.body().getData());
//                        String temp = response.body().getData().getWeather().get(0).getMaxtempC();
////                        Weather[] weathers = response.body().getData().getWeather();
////                        WeatherWrapper[] weatherWrappers = Utils.getWeatherWrpped(weathers, city.getId());
////                        city.setWeatherWrapper(weatherWrappers);
//                        DatabaseUtils.getInstance(context).copyOrUpdate(city, temp);
////                        DatabaseUtils.getInstance(context).createWeatherForCity(weatherWrappers, city.getId());
//                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("hammad", "GHH");
                }
            });
        }
    }
}
