package com.mttnow.forecastexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.Forecast;
import com.mttnow.forecastexample.entites.WeatherWrapper;

import org.parceler.Parcels;

import io.realm.RealmResults;

/**
 * Created by alahammad on 12/3/15.
 */
public class ForecastDetailsFragment extends Fragment {

    public static final String FORECAST_KEY = "selected_forecast";
    private RealmResults<WeatherWrapper> mSelectedForecast;

    public static ForecastDetailsFragment getInstance(WeatherWrapper[] forecast) {
        ForecastDetailsFragment forecastDetailsFragment = new ForecastDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(FORECAST_KEY, Parcels.wrap(forecast));
        forecastDetailsFragment.setArguments(bundle);
        return forecastDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecastdetails, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        mSelectedForecast = Parcels.unwrap(getArguments().getParcelable(FORECAST_KEY));
        Log.d("ha", "stiop");
    }


}
