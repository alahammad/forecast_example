package com.mttnow.forecastexample.entites;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alahammad on 12/3/15.
 */
public class City extends RealmObject {

    @PrimaryKey
    private long id;

    private String cityName;

    private String temp;


    //     because realm limitation
    @Ignore
    private WeatherWrapper[] weatherWrapper;

    public City() {
    }


    public City(String cityName, String temp) {
        this.cityName = cityName;
        this.temp = temp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public WeatherWrapper[] getWeatherWrapper() {
        return weatherWrapper;
    }

    public void setWeatherWrapper(WeatherWrapper[] weatherWrapper) {
        this.weatherWrapper = weatherWrapper;
    }
}