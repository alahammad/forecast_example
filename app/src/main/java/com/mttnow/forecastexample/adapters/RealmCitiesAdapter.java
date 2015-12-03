package com.mttnow.forecastexample.adapters;

import android.content.Context;

import com.mttnow.forecastexample.entites.City;

import io.realm.RealmResults;

/**
 * Created by alahammad on 12/3/15.
 */
public class RealmCitiesAdapter extends RealmModelAdapter<City> {
    public RealmCitiesAdapter(Context context, RealmResults<City> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
