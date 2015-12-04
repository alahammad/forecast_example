package com.mttnow.forecastexample.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mttnow.forecastexample.R;

/**
 * Created by alahammad on 12/4/15.
 */
public class CustomFontTextView extends TextView {


    public CustomFontTextView(Context context) {
        this(context, null);
        applyCustomFont(context);

    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        applyCustomFont(context);

    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        applyCustomFont(context);

    }

    private void applyCustomFont(Context context) {
        String customFont = context.getString(R.string.font_name);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), customFont);
        //Build a custom typeface-cache here!
        this.setTypeface(typeface);
    }

}
