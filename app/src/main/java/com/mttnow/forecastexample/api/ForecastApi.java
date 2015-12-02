package com.mttnow.forecastexample.api;

import com.mttnow.forecastexample.entites.Forecast;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by alahammad on 12/2/15.
 */
public interface ForecastApi {

    @GET("weather.ashx")
    Call<Forecast> getForecast(
            @Query("q") String country,
            @Query("format") String format,
            @Query("key") String apiKey);

}
