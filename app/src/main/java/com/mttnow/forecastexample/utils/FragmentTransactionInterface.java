package com.mttnow.forecastexample.utils;

import android.support.v4.app.Fragment;

/**
 * Created by alahammad on 12/3/15.
 */
public interface FragmentTransactionInterface {

    void changeFragment(Fragment fragment);


    void changeFragment(Fragment fragment, boolean addToBackStack);
}
