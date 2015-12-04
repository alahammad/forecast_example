package com.mttnow.forecastexample.entites;

/**
 * Created by alahammad on 12/4/15.
 */
public class Search_api {

    private Result[] result;

    public Result[] getResult() {
        return result;
    }

    public void setResult(Result[] result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ClassPojo [result = " + result + "]";
    }
}
