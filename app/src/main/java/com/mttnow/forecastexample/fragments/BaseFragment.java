package com.mttnow.forecastexample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by alahammad on 12/6/15.
 */
public class BaseFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
}
