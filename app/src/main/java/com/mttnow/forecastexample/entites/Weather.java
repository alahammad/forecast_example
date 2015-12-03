package com.mttnow.forecastexample.entites;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by alahammad on 12/2/15.
 */
public class Weather extends RealmObject {

    private String mintempF;

    private String uvIndex;

    private String mintempC;

    private String maxtempC;

    private String maxtempF;

    private RealmList<Hourly> hourly;

    private String date;

    private RealmList<Astronomy> astronomy;

    public String getMintempF() {
        return mintempF;
    }

    public void setMintempF(String mintempF) {
        this.mintempF = mintempF;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(String maxtempF) {
        this.maxtempF = maxtempF;
    }

    public RealmList<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(RealmList<Hourly> hourly) {
        this.hourly = hourly;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RealmList<Astronomy> getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(RealmList<Astronomy> astronomy) {
        this.astronomy = astronomy;
    }

}
