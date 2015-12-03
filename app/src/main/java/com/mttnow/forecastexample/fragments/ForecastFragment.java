package com.mttnow.forecastexample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.entites.WeatherWrapper;
import com.mttnow.forecastexample.presenter.ForecastPresenter;
import com.mttnow.forecastexample.presenter.ForecastPresenterImp;
import com.mttnow.forecastexample.adapters.CitiesAdapter;
import com.mttnow.forecastexample.utils.DatabaseUtils;
import com.mttnow.forecastexample.adapters.RealmCitiesAdapter;
import com.mttnow.forecastexample.utils.FragmentTransactionInterface;
import com.mttnow.forecastexample.utils.Utils;
import com.mttnow.forecastexample.view.ForecastView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

/**
 * Created by alahammad on 12/3/15.
 */
public class ForecastFragment extends Fragment implements ForecastView, SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.progressBar)
    ProgressBar mLoadingProgress;


    ForecastPresenter mPresenter;

    @Bind(R.id.cities_list)
    RecyclerView mRecycleView;

    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout mSwipeList;


    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private CitiesAdapter mAdapter;
    private RealmCitiesAdapter mRealmAdapter;

    FragmentTransactionInterface fragmentTransactionInterface;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentTransactionInterface = (FragmentTransactionInterface) context;
        } catch (ClassCastException ex) {
            Log.d("Error", "Please implement FragmentTransactionInterface in parent activity");
        }
    }

    public static ForecastFragment getInstance() {
        ForecastFragment forecastFragment = new ForecastFragment();
        return forecastFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forecast_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new ForecastPresenterImp(this);
        setupActionBar();
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new CitiesAdapter();

        mRealmAdapter = new RealmCitiesAdapter(getActivity().getApplicationContext(), DatabaseUtils.getInstance(getActivity()).getAllCities(), true);
        mAdapter.setRealmAdapter(mRealmAdapter);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CitiesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                City weatherWrapper = mAdapter.getRealmAdapter().getItem(position);
                long id = weatherWrapper.getId();
                RealmResults<WeatherWrapper> weatherWrappers = DatabaseUtils.getInstance(getActivity()).getWeathers(id);

                fragmentTransactionInterface.changeFragment(ForecastDetailsFragment.getInstance(Utils.getWeatherWrpped(weatherWrappers, id)), true);
            }
        });
        refresh();
    }

    private void refresh() {

        mPresenter.loadForecasts(getActivity(), mAdapter);
    }


    private void setupActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.fab)
    public void floatActionButton() {
//           mPresenter.loadForecast("?>", getActivity(),mAdapter);
//        mRealmAdapter.notifyDataSetChanged();
        fragmentTransactionInterface.changeFragment(AddForecastFragment.getInstance(), true);
    }


    @Override
    public void stopLoading() {
        mLoadingProgress.setVisibility(View.GONE);
        mSwipeList.setRefreshing(false);
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void onRefresh() {
        refresh();
    }

}
