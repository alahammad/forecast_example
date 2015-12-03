package com.mttnow.forecastexample.utils;

import com.mttnow.forecastexample.adapters.RealmModelAdapter;
import com.mttnow.forecastexample.entites.Weather;
import com.mttnow.forecastexample.entites.WeatherWrapper;

import io.realm.RealmResults;

/**
 * Created by alahammad on 12/3/15.
 */

public class Utils {

    public static WeatherWrapper[] getWeatherWrpped(Weather[] weathers, long cityId) {
        WeatherWrapper[] wrappers = new WeatherWrapper[weathers.length];
        for (int i = 0; i < weathers.length; i++) {
            wrappers[i] = new WeatherWrapper(weathers[i].getMaxtempC(), weathers[i].getMintempC(), weathers[i].getDate(), weathers[i].getHourly()[0].getWeatherDesc()[0].getValue(), weathers[i].getHourly()[0].getHumidity(), cityId);
        }
        return wrappers;
    }


    public static WeatherWrapper[] getWeatherWrpped(RealmResults<WeatherWrapper> weathers, long cityID) {
        WeatherWrapper[] wrappers = new WeatherWrapper[weathers.size()];
        for (int i = 0; i < weathers.size(); i++) {
            wrappers[i] = new WeatherWrapper(weathers.get(i).getMaxtempC(), weathers.get(i).getMintempC(), weathers.get(i).getDate(), weathers.get(i).getWeatherDesc(), weathers.get(i).getHumidity(), cityID);
        }
        return wrappers;
    }
}
