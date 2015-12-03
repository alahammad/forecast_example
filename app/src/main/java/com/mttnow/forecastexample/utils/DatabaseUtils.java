package com.mttnow.forecastexample.utils;

import android.content.Context;

import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.entites.Weather;
import com.mttnow.forecastexample.entites.WeatherWrapper;

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

    public void create(City city) {
        if (!checkIfCityExists(city.getCityName())) {
            // realm doesn't support auto crementing
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

    public void createWeatherForCity(WeatherWrapper[] weatherWrapper, long cityID) {
        for (WeatherWrapper weather : weatherWrapper
                ) {
            Number number = _realm.where(WeatherWrapper.class).max("id");
            int id = number == null ? 0 : number.intValue() + 1;
            weather.setId(id);
            _realm.beginTransaction();
            WeatherWrapper cityRealm = _realm.copyToRealm(weather);
            _realm.commitTransaction();
        }

    }

    public RealmResults<WeatherWrapper> getWeathers(long city) {
        RealmQuery<WeatherWrapper> query = _realm.where(WeatherWrapper.class);
        query.equalTo("cityID", city);
        return query.findAll();
    }

    public void clearWeatherTable() {
        _realm.beginTransaction();
        _realm.clear(WeatherWrapper.class);
        _realm.commitTransaction();
    }

}
