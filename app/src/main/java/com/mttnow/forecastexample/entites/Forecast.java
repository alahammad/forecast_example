package com.mttnow.forecastexample.entites;

/**
 * Created by alahammad on 12/2/15.
 */
public class Forecast {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }

}
