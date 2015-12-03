package com.mttnow.forecastexample.entites;

import io.realm.RealmObject;

/**
 * Created by alahammad on 12/3/15.
 */
public class Error extends RealmObject {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
