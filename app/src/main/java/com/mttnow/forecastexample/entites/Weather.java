package com.mttnow.forecastexample.entites;

/**
 * Created by alahammad on 12/2/15.
 */
public class Weather {

    private String mintempF;

    private String uvIndex;

    private String mintempC;

    private String maxtempC;

    private String maxtempF;

    private Hourly[] hourly;

    private String date;

    private Astronomy[] astronomy;

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

    public Hourly[] getHourly() {
        return hourly;
    }

    public void setHourly(Hourly[] hourly) {
        this.hourly = hourly;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Astronomy[] getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy[] astronomy) {
        this.astronomy = astronomy;
    }

    @Override
    public String toString() {
        return "ClassPojo [mintempF = " + mintempF + ", uvIndex = " + uvIndex + ", mintempC = " + mintempC + ", maxtempC = " + maxtempC + ", maxtempF = " + maxtempF + ", hourly = " + hourly + ", date = " + date + ", astronomy = " + astronomy + "]";
    }
}
