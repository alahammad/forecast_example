package com.mttnow.forecastexample;

import android.app.Application;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Created by alahammad on 12/4/15.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Install CustomActivityOnCrash
        CustomActivityOnCrash.install(this);
        CustomActivityOnCrash.setShowErrorDetails(false);
        CustomActivityOnCrash.setEnableAppRestart(false);
    }
}
