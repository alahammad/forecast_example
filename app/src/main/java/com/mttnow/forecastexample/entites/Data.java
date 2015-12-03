package com.mttnow.forecastexample.entites;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by alahammad on 12/2/15.
 */
public class Data {

    private Current_condition[] current_condition;
    private Error[] error;

    private Request[] request;

    private Weather[] weather;

    public Current_condition[] getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(Current_condition[] current_condition) {
        this.current_condition = current_condition;
    }

    public Request[] getRequest() {
        return request;
    }

    public void setRequest(Request[] request) {
        this.request = request;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }


    public Error[] getError() {
        return error;
    }

    public void setError(Error[] error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ClassPojo [current_condition = " + current_condition + ", request = " + request + ", weather = " + weather + "]";
    }


}
