package com.mttnow.forecastexample.utils;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mttnow.forecastexample.R;

/**
 * Created by alahammad on 12/3/15.
 */
public class DialogsUtils {

    private static DialogsUtils _instance;

    public static DialogsUtils getInstance() {
        if (_instance == null)
            _instance = new DialogsUtils();
        return _instance;
    }

    public void showDialog(Context context, String msg) {
        new MaterialDialog.Builder(context)
                .title(context.getString(R.string.app_name))
                .content(msg)
                .positiveText("ok")
                .show();
    }

}
