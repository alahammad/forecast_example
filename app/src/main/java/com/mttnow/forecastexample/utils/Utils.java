package com.mttnow.forecastexample.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.City;
import com.squareup.picasso.Picasso;

/**
 * Created by alahammad on 12/4/15.
 */
public class Utils {

    private static final String SHARED_NAME = "forecast_app";
    private static final String DATA_ADDED = "added";

    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    public static void addDefaultCities(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        int value = sharedPreferences.getInt(DATA_ADDED, 0);
        if (value == 0) {
            DatabaseUtils databaseUtils = DatabaseUtils.getInstance(context);
            String[] cities = context.getResources().getStringArray(R.array.default_cities);
            for (String city : cities) {
                databaseUtils.createCity(new City(city, ""));
            }
            sharedPreferences.edit().putInt(DATA_ADDED, 1).commit();
        }
    }

    public static void loadImage(Context context, ImageView im, String url) {
        Picasso.with(context).load(url).into(im);
    }

    // find mid temp
    public static String getMidTemp(String min, String max) {
        try {
            int minTemp = Integer.valueOf(min);
            int maxTemp = Integer.valueOf(max);
            return String.valueOf((maxTemp + minTemp) / 2);
        } catch (ClassCastException ex) {

        }
        return max;
    }
}
