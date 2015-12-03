package com.mttnow.forecastexample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.utils.DatabaseUtils;

public class SplashActivity extends AppCompatActivity {

    private static final int TIMEOUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        showSplash();
        addDefaultCities();
    }

    private void addDefaultCities() {
        DatabaseUtils databaseUtils = DatabaseUtils.getInstance(this);
        databaseUtils.clearWeatherTable();
        String[] cities = getResources().getStringArray(R.array.default_cities);
        for (String city : cities) {
            City cityObject = new City(city, "0");
            databaseUtils.create(cityObject);
        }
    }

    private void showSplash() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        };
        handler.postDelayed(runnable, TIMEOUT);
    }
}
