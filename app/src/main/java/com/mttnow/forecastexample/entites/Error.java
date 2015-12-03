package com.mttnow.forecastexample.entites;

/**
 * Created by alahammad on 12/3/15.
 */
public class Error {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ClassPojo [msg = " + msg + "]";
    }
}
