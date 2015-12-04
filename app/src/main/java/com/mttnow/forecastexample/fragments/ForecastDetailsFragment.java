package com.mttnow.forecastexample.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.pwittchen.weathericonview.WeatherIconView;
import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.Data;
import com.mttnow.forecastexample.presenter.ForecastDetailsPresenter;
import com.mttnow.forecastexample.presenter.ForecastDetailsPresenterImp;
import com.mttnow.forecastexample.view.ForecastDetailsView;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alahammad on 12/3/15.
 */
public class ForecastDetailsFragment extends Fragment implements ForecastDetailsView {

    @Bind(R.id.tv_city_name)
    TextView mCityName;

    @Bind(R.id.tv_time)
    TextView mTime;

    @Bind(R.id.pb_details)
    ProgressBar mLoading;

    @Bind(R.id.weatherIcon)
    WeatherIconView mWeather;

    @Bind(R.id.tv_day1_date)
    TextView mDay1Date;

    @Bind(R.id.tv_day1_temp)
    TextView mDay1Temp;

    @Bind(R.id.tv_day2_date)
    TextView mDay2Date;

    @Bind(R.id.tv_day2_temp)
    TextView mDay2Temp;

    @Bind(R.id.tv_day3_date)
    TextView mDay3Date;

    @Bind(R.id.tv_day3_temp)
    TextView mDay3Temp;

    @Bind(R.id.tv_day4_date)
    TextView mDay4Date;

    @Bind(R.id.tv_day4_temp)
    TextView mDay4Temp;


    @Bind(R.id.tv_city_temp)
    TextView mTemp;

    private ForecastDetailsPresenter mPresenter;

    public static final String FORECAST_KEY = "selected_forecast";
    private String mSelectedCity;

    public static ForecastDetailsFragment getInstance(String cityName) {
        ForecastDetailsFragment forecastDetailsFragment = new ForecastDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FORECAST_KEY, cityName);
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
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new ForecastDetailsPresenterImp(this);
        mSelectedCity = getArguments().getString(FORECAST_KEY);
        mCityName.setText(mSelectedCity);
        mPresenter.loadForecast(mSelectedCity, getActivity());
        mWeather.setIconResource(getString(R.string.wi_day_sunny));
        mWeather.setIconSize(50);
        mWeather.setIconColor(Color.BLACK);
    }


    @Override
    public void stopLoading() {
        mLoading.setVisibility(View.GONE);
    }

    @Override
    public void startLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void dataLoaded(Data data) {
        mCityName.setText(data.getRequest().get(0).getQuery());
        String temp = getMidTemp(data.getWeather().get(0).getMintempC(), data.getWeather().get(0).getMaxtempC());
        mTemp.setText(temp);

        mDay1Date.setText(data.getWeather().get(1).getDate());
        temp = getMidTemp(data.getWeather().get(1).getMintempC(), data.getWeather().get(1).getMaxtempC());
        mDay1Temp.setText(temp + " \u2103");

        mDay2Date.setText(data.getWeather().get(2).getDate());
        temp = getMidTemp(data.getWeather().get(2).getMintempC(), data.getWeather().get(2).getMaxtempC());
        mDay2Temp.setText(temp + " \u2103");

        mDay3Date.setText(data.getWeather().get(3).getDate());
        temp = getMidTemp(data.getWeather().get(3).getMintempC(), data.getWeather().get(3).getMaxtempC());
        mDay3Temp.setText(temp + " \u2103");


        mDay4Date.setText(data.getWeather().get(4).getDate());
        temp = getMidTemp(data.getWeather().get(4).getMintempC(), data.getWeather().get(4).getMaxtempC());
        mDay4Temp.setText(temp + " \u2103");
    }


    // find mid temp
    private String getMidTemp(String min, String max) {
        try {
            int minTemp = Integer.valueOf(min);
            int maxTemp = Integer.valueOf(max);
            return String.valueOf((maxTemp + minTemp) / 2);
        } catch (ClassCastException ex) {

        }
        return max;
    }
}
