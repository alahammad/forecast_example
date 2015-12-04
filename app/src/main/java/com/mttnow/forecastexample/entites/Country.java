package com.mttnow.forecastexample.entites;

/**
 * Created by alahammad on 12/4/15.
 */
public class Country {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ClassPojo [value = " + value + "]";
    }
}
