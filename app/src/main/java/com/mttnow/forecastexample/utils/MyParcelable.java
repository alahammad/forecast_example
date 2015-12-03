package com.mttnow.forecastexample.utils;

/**
 * Created by alahammad on 12/3/15.
 * because realm parceable is weak and not working so i made my own
 */
public class MyParcelable {

    private Object object;

    public static MyParcelable _instance;

    public static MyParcelable getInstance() {
        if (_instance == null)
            _instance = new MyParcelable();
        return _instance;
    }

    public void setObject(Object o) {
        this.object = o;
    }

    public Object getObject() {
        return object;
    }
}
