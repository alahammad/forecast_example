package com.mttnow.forecastexample.presenter;

import android.content.Context;

import com.mttnow.forecastexample.adapters.CitiesAdapter;
import com.mttnow.forecastexample.adapters.RealmCitiesAdapter;

/**
 * Created by alahammad on 12/2/15.
 */
public interface ForecastPresenter {


    public void loadForecasts(Context context, CitiesAdapter adapter);

}
