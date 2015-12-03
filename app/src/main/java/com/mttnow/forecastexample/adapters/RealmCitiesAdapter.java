package com.mttnow.forecastexample.adapters;

import android.content.Context;

import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.entites.Data;

import io.realm.RealmResults;

/**
 * Created by alahammad on 12/3/15.
 */
public class RealmCitiesAdapter extends RealmModelAdapter<Data> {
    public RealmCitiesAdapter(Context context, RealmResults<Data> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
