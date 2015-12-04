package com.mttnow.forecastexample.entites;


import android.os.Parcel;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alahammad on 12/2/15.
 */

public class Data extends RealmObject {

    @PrimaryKey
    private long id;

    private RealmList<Current_condition> current_condition;
    private RealmList<Error> error;

    private RealmList<Request> request;

    private RealmList<Weather> weather;

    public RealmList<Current_condition> getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(RealmList<Current_condition> current_condition) {
        this.current_condition = current_condition;
    }

    public RealmList<Request> getRequest() {
        return request;
    }

    public void setRequest(RealmList<Request> request) {
        this.request = request;
    }

    public RealmList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(RealmList<Weather> weather) {
        this.weather = weather;
    }


    public RealmList<Error> getError() {
        return error;
    }

    public void setError(RealmList<Error> error) {
        this.error = error;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
