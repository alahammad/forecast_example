package com.mttnow.forecastexample.entites;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by alahammad on 12/2/15.
 */
public class Forecast extends RealmObject {
    private Data data;


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



}

