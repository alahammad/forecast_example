package com.mttnow.forecastexample.utils;

import android.content.Context;

import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.entites.Data;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by alahammad on 12/3/15.
 */
public class DatabaseUtils {

    private Realm _realm;
    private static DatabaseUtils _databaseUtils;

    public DatabaseUtils(Context context) {
        _realm = Realm.getInstance(context);
        _realm.setAutoRefresh(true);
    }

    // singleton design pattern
    public static DatabaseUtils getInstance(Context context) {
        if (_databaseUtils == null)
            _databaseUtils = new DatabaseUtils(context);

        return _databaseUtils;
    }


    public void copyOrUpdate(City city, String temp) {
        _realm.beginTransaction();
        city.setTemp(temp);
        City realmCity = _realm.copyToRealmOrUpdate(city);

        _realm.commitTransaction();
    }

    public void createCity(City city) {
        if (!checkIfCityExists(city.getCityName())) {

            // realm doesn't support auto incremental
            Number number = _realm.where(City.class).max("id");
            int id = number == null ? 0 : number.intValue() + 1;
            city.setId(id);
            _realm.beginTransaction();
            City cityRealm = _realm.copyToRealmOrUpdate(city);
            _realm.commitTransaction();

        }
    }

    // check if element is already inserted
    public boolean checkIfCityExists(String city) {
        RealmQuery<City> query = _realm.where(City.class)
                .equalTo("cityName", city);
        return query.count() == 0 ? false : true;
    }


    public RealmResults<City> getAllCities() {
        RealmQuery<City> query = _realm.where(City.class);
        return query.findAll();
    }

    public void createData(Data data) {
        Number number = _realm.where(Data.class).max("id");
        int id = number == null ? 0 : number.intValue() + 1;
        data.setId(id);

        _realm.beginTransaction();
        Data data1 = _realm.copyToRealmOrUpdate(data);
        _realm.commitTransaction();
    }


    public void deleteCity(City city) {
        _realm.beginTransaction();
        city.removeFromRealm();

        _realm.commitTransaction();
    }

}
