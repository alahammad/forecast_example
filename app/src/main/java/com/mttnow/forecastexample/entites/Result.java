package com.mttnow.forecastexample.entites;

import android.graphics.Region;

/**
 * Created by alahammad on 12/4/15.
 */
public class Result {
    private Region[] region;

    private WeatherUrl[] weatherUrl;

    private AreaName[] areaName;

    private String longitude;

    private String latitude;

    private String population;

    private Country[] country;

    public Region[] getRegion() {
        return region;
    }

    public void setRegion(Region[] region) {
        this.region = region;
    }

    public WeatherUrl[] getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(WeatherUrl[] weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public AreaName[] getAreaName() {
        return areaName;
    }

    public void setAreaName(AreaName[] areaName) {
        this.areaName = areaName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Country[] getCountry() {
        return country;
    }

    public void setCountry(Country[] country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ClassPojo [region = " + region + ", weatherUrl = " + weatherUrl + ", areaName = " + areaName + ", longitude = " + longitude + ", latitude = " + latitude + ", population = " + population + ", country = " + country + "]";
    }

}
