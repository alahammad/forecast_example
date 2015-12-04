package com.mttnow.forecastexample.view;

import com.mttnow.forecastexample.entites.Data;

/**
 * Created by alahammad on 12/4/15.
 */
public interface ForecastDetailsView extends ForecastView {

    public void dataLoaded(Data data);
}
