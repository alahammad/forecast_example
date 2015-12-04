package com.mttnow.forecastexample.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.adapters.CitiesAdapter;
import com.mttnow.forecastexample.api.ApiGenerator;
import com.mttnow.forecastexample.api.ForecastApi;
import com.mttnow.forecastexample.entites.*;
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
    public void loadForecasts(final Context context, final CitiesAdapter adapter) {
        forecastView.startLoading();
        ForecastApi retrofit = ApiGenerator.createService(ForecastApi.class);
        int count = adapter.getItemCount();
        for (int i = 0; i < adapter.getItemCount(); i++) {
            final int index = i;
            Call<Forecast> call = retrofit.getForecast(adapter.getItem(i).getCityName(), context.getString(R.string.api_key));
            call.enqueue(new Callback<Forecast>() {
                @Override
                public void onResponse(Response<Forecast> response, Retrofit retrofit) {

                    if (response.isSuccess()) {
                        DatabaseUtils.getInstance(context).createData(response.body().getData());
                        City city = adapter.getItem(index);
//                            DatabaseUtils.getInstance(context).createData(response.body().getData());
                        String temp = Utils.getMidTemp(response.body().getData().getWeather().get(0).getMintempC(), response.body().getData().getWeather().get(0).getMaxtempC());
                        DatabaseUtils.getInstance(context).copyOrUpdate(city, temp);
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("hammad", "GHH");
                }
            });
        }
        forecastView.stopLoading();
    }
}
