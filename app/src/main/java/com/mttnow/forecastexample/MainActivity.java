package com.mttnow.forecastexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mttnow.forecastexample.api.ForecastApi;
import com.mttnow.forecastexample.entites.Forecast;
import com.mttnow.forecastexample.presenter.ForecastPresenter;
import com.mttnow.forecastexample.presenter.ForecastPresenterImp;
import com.mttnow.forecastexample.view.ForecastView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements ForecastView {

    @Bind(R.id.progressBar)
    ProgressBar mLoadingProgress;


    ForecastPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configActionBar();
        mPresenter = new ForecastPresenterImp(this);

    }

    @OnClick(R.id.fab)
    private void floatActionButton() {
        mPresenter.loadForecast("Dublin", MainActivity.this);
    }

    private void configActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public void stopLoading() {
        mLoadingProgress.setVisibility(View.GONE);
    }

    @Override
    public void startLoading() {
        mLoadingProgress.setVisibility(View.VISIBLE);
    }
}
