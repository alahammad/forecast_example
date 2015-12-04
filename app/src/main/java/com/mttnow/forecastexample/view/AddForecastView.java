package com.mttnow.forecastexample.view;

import com.mttnow.forecastexample.adapters.CitiesAdapter;
import com.mttnow.forecastexample.adapters.CitiesResultAdapter;

/**
 * Created by alahammad on 12/4/15.
 */
public interface AddForecastView extends ForecastView {


    public void loadComplete(CitiesResultAdapter adapter);


}
