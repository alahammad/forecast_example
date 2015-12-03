package com.mttnow.forecastexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.mttnow.forecastexample.fragments.ForecastFragment;
import com.mttnow.forecastexample.presenter.ForecastPresenter;
import com.mttnow.forecastexample.presenter.ForecastPresenterImp;
import com.mttnow.forecastexample.utils.FragmentTransactionInterface;
import com.mttnow.forecastexample.view.ForecastView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FragmentTransactionInterface {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        setupActionBar();
        if (savedInstanceState == null)
            changeFragment(ForecastFragment.getInstance());
    }


    @Override
    public void changeFragment(Fragment fragment) {
        changeFragment(fragment, false);
    }

    @Override
    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,
                R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.container, fragment);

        if (addToBackStack)
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
