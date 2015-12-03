package com.mttnow.forecastexample.entites;

import io.realm.RealmObject;

/**
 * Created by alahammad on 12/2/15.
 */
public class Request extends RealmObject {

    private String query;

    private String type;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
