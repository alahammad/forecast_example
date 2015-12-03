package com.mttnow.forecastexample.entites;

import android.os.Parcelable;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alahammad on 12/3/15.
 */

@Parcel(
        value = Parcel.Serialization.BEAN,
        analyze = {WeatherWrapper.class})

public class WeatherWrapper extends RealmObject {

    @PrimaryKey
    private int id;

    private long cityID;

    private String maxtempC;

    private String mintempC;

    private String date;

    private String weatherDesc;

    private String humidity;

    public WeatherWrapper() {
    }

    public WeatherWrapper(String maxtempC, String mintempC, String date, String weatherDesc, String humidity, long cityID) {
        this.maxtempC = maxtempC;
        this.mintempC = mintempC;
        this.date = date;
        this.weatherDesc = weatherDesc;
        this.humidity = humidity;
        this.cityID = cityID;
    }


    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public long getCityID() {
        return cityID;
    }

    public void setCityID(long cityID) {
        this.cityID = cityID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
