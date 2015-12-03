package com.mttnow.forecastexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.Data;
import com.mttnow.forecastexample.entites.Forecast;
import com.mttnow.forecastexample.entites.WeatherWrapper;
import com.mttnow.forecastexample.utils.MyParcelable;

import org.parceler.Parcels;

import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by alahammad on 12/3/15.
 */
public class ForecastDetailsFragment extends Fragment {

    public static final String FORECAST_KEY = "selected_forecast";
    private Data mSelectedForecast;

    public static ForecastDetailsFragment getInstance(Data forecast) {
        ForecastDetailsFragment forecastDetailsFragment = new ForecastDetailsFragment();

        MyParcelable.getInstance().setObject(forecast);
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
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        mSelectedForecast = (Data) MyParcelable.getInstance().getObject();
        Log.d("ha", "stiop");
    }


}
