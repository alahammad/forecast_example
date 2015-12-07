package com.mttnow.forecastexample;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import io.fabric.sdk.android.Fabric;

/**
 * Created by alahammad on 12/4/15.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        CustomActivityOnCrash.install(this);
        CustomActivityOnCrash.setShowErrorDetails(false);
        CustomActivityOnCrash.setEnableAppRestart(false);
    }
}
