package com.mttnow.forecastexample.presenter;

import android.content.Context;

import com.mttnow.forecastexample.view.ForecastView;

/**
 * Created by alahammad on 12/4/15.
 */
public interface AddForecastPresenter {

    public void searchCityForecast(String city, Context context);
}
