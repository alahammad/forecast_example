package com.mttnow.forecastexample.entites;

import io.realm.RealmObject;

/**
 * Created by alahammad on 12/2/15.
 */
public class Astronomy extends RealmObject {

    private String moonset;

    private String sunset;

    private String sunrise;

    private String moonrise;

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }


}
