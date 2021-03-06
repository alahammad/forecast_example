package com.mttnow.forecastexample.entites;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by alahammad on 12/2/15.
 */
public class Hourly extends RealmObject {
    private String chanceofremdry;

    private String chanceofovercast;

    private String visibility;

    private String FeelsLikeC;

    private String chanceofhightemp;

    private String chanceofrain;

    private String chanceoffog;

    private String WindGustKmph;

    private String HeatIndexF;

    private String HeatIndexC;

    private RealmList<WeatherIconUrl> weatherIconUrl;

    private String time;

    private String WindChillC;

    private String chanceofsunshine;

    private String WindGustMiles;

    private String chanceofsnow;

    private String WindChillF;

    private String tempC;

    private String cloudcover;

    private String pressure;

    private String windspeedMiles;

    private String chanceofwindy;

    private String precipMM;

    private String winddirDegree;

    private String winddir16Point;

    private String humidity;

    private String chanceoffrost;

    private String FeelsLikeF;

    private String windspeedKmph;

    private String DewPointC;

    private String chanceofthunder;

    private String tempF;

    private String weatherCode;

    private String DewPointF;

    private RealmList<WeatherDesc> weatherDesc;

    public String getChanceofremdry() {
        return chanceofremdry;
    }

    public void setChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
    }

    public String getChanceofovercast() {
        return chanceofovercast;
    }

    public void setChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getFeelsLikeC() {
        return FeelsLikeC;
    }

    public void setFeelsLikeC(String FeelsLikeC) {
        this.FeelsLikeC = FeelsLikeC;
    }

    public String getChanceofhightemp() {
        return chanceofhightemp;
    }

    public void setChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
    }

    public String getChanceofrain() {
        return chanceofrain;
    }

    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    public String getChanceoffog() {
        return chanceoffog;
    }

    public void setChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
    }

    public String getWindGustKmph() {
        return WindGustKmph;
    }

    public void setWindGustKmph(String WindGustKmph) {
        this.WindGustKmph = WindGustKmph;
    }

    public String getHeatIndexF() {
        return HeatIndexF;
    }

    public void setHeatIndexF(String HeatIndexF) {
        this.HeatIndexF = HeatIndexF;
    }

    public String getHeatIndexC() {
        return HeatIndexC;
    }

    public void setHeatIndexC(String HeatIndexC) {
        this.HeatIndexC = HeatIndexC;
    }

    public RealmList<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(RealmList<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWindChillC() {
        return WindChillC;
    }

    public void setWindChillC(String WindChillC) {
        this.WindChillC = WindChillC;
    }

    public String getChanceofsunshine() {
        return chanceofsunshine;
    }

    public void setChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
    }

    public String getWindGustMiles() {
        return WindGustMiles;
    }

    public void setWindGustMiles(String WindGustMiles) {
        this.WindGustMiles = WindGustMiles;
    }

    public String getChanceofsnow() {
        return chanceofsnow;
    }

    public void setChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
    }

    public String getWindChillF() {
        return WindChillF;
    }

    public void setWindChillF(String WindChillF) {
        this.WindChillF = WindChillF;
    }

    public String getTempC() {
        return tempC;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public String getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    public String getChanceofwindy() {
        return chanceofwindy;
    }

    public void setChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    public String getWinddirDegree() {
        return winddirDegree;
    }

    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getChanceoffrost() {
        return chanceoffrost;
    }

    public void setChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
    }

    public String getFeelsLikeF() {
        return FeelsLikeF;
    }

    public void setFeelsLikeF(String FeelsLikeF) {
        this.FeelsLikeF = FeelsLikeF;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public String getDewPointC() {
        return DewPointC;
    }

    public void setDewPointC(String DewPointC) {
        this.DewPointC = DewPointC;
    }

    public String getChanceofthunder() {
        return chanceofthunder;
    }

    public void setChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
    }

    public String getTempF() {
        return tempF;
    }

    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getDewPointF() {
        return DewPointF;
    }

    public void setDewPointF(String DewPointF) {
        this.DewPointF = DewPointF;
    }

    public RealmList<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(RealmList<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }


}
