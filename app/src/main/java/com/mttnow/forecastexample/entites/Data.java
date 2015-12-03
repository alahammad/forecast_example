package com.mttnow.forecastexample.entites;


import org.parceler.Parcel;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by alahammad on 12/2/15.
 */

@Parcel(
        value = Parcel.Serialization.BEAN,
        analyze = {Data.class})


public class Data extends RealmObject {

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


}
