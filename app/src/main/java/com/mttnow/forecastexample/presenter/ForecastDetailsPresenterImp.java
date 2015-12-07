package com.mttnow.forecastexample.presenter;

import android.content.Context;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.api.ApiGenerator;
import com.mttnow.forecastexample.api.ForecastApi;
import com.mttnow.forecastexample.entites.Forecast;
import com.mttnow.forecastexample.utils.DialogsUtils;
import com.mttnow.forecastexample.view.ForecastDetailsView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by alahammad on 12/4/15.
 */
public class ForecastDetailsPresenterImp implements ForecastDetailsPresenter {

    private ForecastDetailsView forecastView;


    public ForecastDetailsPresenterImp(ForecastDetailsView forecastView) {
        this.forecastView = forecastView;
    }


    @Override
    public void loadForecast(final String country, final Context context) {
        forecastView.startLoading();
        ForecastApi retrofit = ApiGenerator.createService(ForecastApi.class);
        Call<Forecast> call = retrofit.getForecast(country, context.getString(R.string.api_key));

        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Response<Forecast> response, Retrofit retrofit) {
                forecastView.stopLoading();
                if (response.isSuccess()) {
                    forecastView.dataLoaded(response.body().getData());
                } else {
                    DialogsUtils.getInstance().showDialog(context, context.getString(R.string.api_error));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                forecastView.stopLoading();
                DialogsUtils.getInstance().showDialog(context, context.getString(R.string.api_error));
            }
        });

    }
}
