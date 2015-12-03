package com.mttnow.forecastexample.entites;

import io.realm.RealmObject;

/**
 * Created by alahammad on 12/2/15.
 */
public class WeatherIconUrl extends RealmObject {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
