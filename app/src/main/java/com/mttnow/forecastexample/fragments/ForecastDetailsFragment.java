package com.mttnow.forecastexample.fragments;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.Data;
import com.mttnow.forecastexample.presenter.ForecastDetailsPresenter;
import com.mttnow.forecastexample.presenter.ForecastDetailsPresenterImp;
import com.mttnow.forecastexample.utils.Utils;
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


    @Bind(R.id.iv_day1)
    ImageView mDay1Image;


    @Bind(R.id.iv_day2)
    ImageView mDay2Image;

    @Bind(R.id.iv_day3)
    ImageView mDay3Image;

    @Bind(R.id.iv_day4)
    ImageView mDay4Image;

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
        mTime.setText(data.getWeather().get(0).getDate());
        String temp = Utils.getMidTemp(data.getWeather().get(0).getMintempC(), data.getWeather().get(0).getMaxtempC());
        mTemp.setText(temp);

        mDay1Date.setText(data.getWeather().get(1).getDate());
        temp = Utils.getMidTemp(data.getWeather().get(1).getMintempC(), data.getWeather().get(1).getMaxtempC());
        mDay1Temp.setText(temp + " \u2103");
        Utils.loadImage(getActivity(), mDay1Image, data.getWeather().get(1).getHourly().get(0).getWeatherIconUrl().get(0).getValue());

        mDay2Date.setText(data.getWeather().get(2).getDate());
        temp = Utils.getMidTemp(data.getWeather().get(2).getMintempC(), data.getWeather().get(2).getMaxtempC());
        mDay2Temp.setText(temp + " \u2103");
        Utils.loadImage(getActivity(), mDay2Image, data.getWeather().get(2).getHourly().get(0).getWeatherIconUrl().get(0).getValue());


        mDay3Date.setText(data.getWeather().get(3).getDate());
        temp = Utils.getMidTemp(data.getWeather().get(3).getMintempC(), data.getWeather().get(3).getMaxtempC());
        mDay3Temp.setText(temp + " \u2103");
        Utils.loadImage(getActivity(), mDay3Image, data.getWeather().get(3).getHourly().get(0).getWeatherIconUrl().get(0).getValue());

        mDay4Date.setText(data.getWeather().get(4).getDate());
        temp = Utils.getMidTemp(data.getWeather().get(4).getMintempC(), data.getWeather().get(4).getMaxtempC());
        mDay4Temp.setText(temp + " \u2103");
        Utils.loadImage(getActivity(), mDay4Image, data.getWeather().get(4).getHourly().get(0).getWeatherIconUrl().get(0).getValue());

    }



}
