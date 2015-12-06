package com.mttnow.forecastexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.adapters.CitiesAdapter;
import com.mttnow.forecastexample.adapters.CitiesResultAdapter;
import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.presenter.AddForecastPresenter;
import com.mttnow.forecastexample.presenter.AddForecastPresenterImp;
import com.mttnow.forecastexample.utils.DatabaseUtils;
import com.mttnow.forecastexample.view.AddForecastView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alahammad on 12/3/15.
 */
public class AddForecastFragment extends BaseFragment implements AddForecastView, SearchView.OnQueryTextListener {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.progressBar)
    ProgressBar mLoading;

    @Bind(R.id.result_rv)
    RecyclerView mRecyclerView;

    AddForecastPresenter mPresenter;

    CitiesResultAdapter mAdapter;

    public static AddForecastFragment getInstance() {
        AddForecastFragment addForecastFragment = new AddForecastFragment();
        return addForecastFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        mPresenter = new AddForecastPresenterImp(this);
        mAdapter = new CitiesResultAdapter(new City[0]);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addforecast, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupActionBar();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }


    private void setupActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint(getString(R.string.search_hint));
        searchItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        searchItem.expandActionView();
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        mPresenter.searchCityForecast(query, getActivity());
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
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
    public void loadComplete(CitiesResultAdapter adapter) {
        // incase data returned one item no need to select, just add to list
        mAdapter = adapter;
        if (mAdapter.getItemCount() == 1) {
            City city = mAdapter.getItem(0);
            DatabaseUtils.getInstance(getActivity()).createCity(city);
            getActivity().getSupportFragmentManager().popBackStack();
        } else {
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new CitiesResultAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    City city = mAdapter.getItem(position);
                    DatabaseUtils.getInstance(getActivity()).createCity(city);
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            });
        }
    }
}
