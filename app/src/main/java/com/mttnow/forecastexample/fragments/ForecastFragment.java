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
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.presenter.ForecastPresenter;
import com.mttnow.forecastexample.presenter.ForecastPresenterImp;
import com.mttnow.forecastexample.adapters.CitiesAdapter;
import com.mttnow.forecastexample.utils.DatabaseUtils;
import com.mttnow.forecastexample.adapters.RealmCitiesAdapter;
import com.mttnow.forecastexample.utils.FragmentTransactionInterface;
import com.mttnow.forecastexample.view.ForecastView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by alahammad on 12/3/15.
 */
public class ForecastFragment extends Fragment implements ForecastView, SwipeRefreshLayout.OnRefreshListener, CitiesAdapter.OnItemClickListener {




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


    ItemTouchHelper.Callback callback;


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
        prepareAdapters();
    }

    private void prepareAdapters() {
        mPresenter = new ForecastPresenterImp(this);
        mAdapter = new CitiesAdapter(getActivity());
        mRealmAdapter = new RealmCitiesAdapter(getActivity().getApplicationContext(), DatabaseUtils.getInstance(getActivity()).getAllCities(), true);
        mAdapter.setRealmAdapter(mRealmAdapter);
        mAdapter.setOnItemClickListener(this);
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
        setupActionBar();
        init();
        configSwipe();
        if (savedInstanceState == null) {
            refresh();
        }
    }

    private void init() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeList.setOnRefreshListener(this);
        mRecycleView.setAdapter(mAdapter);
    }

    private void configSwipe() {
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // Could hide open views here if you wanted. //
            }
        };

        mRecycleView.setOnScrollListener(onScrollListener);

    }

    public void refresh() {

        mPresenter.loadForecasts(getActivity(), mAdapter);
    }


    private void setupActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.fab)
    public void floatActionButton() {
        fragmentTransactionInterface.changeFragment(AddForecastFragment.getInstance(), true);
    }


    @Override
    public void stopLoading() {
        if (mSwipeList != null)
        mSwipeList.setRefreshing(false);
    }

    @Override
    public void startLoading() {
        if (mSwipeList != null)
        mSwipeList.setRefreshing(true);
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onItemClick(View view, int position) {
        fragmentTransactionInterface.changeFragment(ForecastDetailsFragment.getInstance(mAdapter.getItem(position).getCityName()), true);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentTransactionInterface = null;
    }
}
