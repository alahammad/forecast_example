package com.mttnow.forecastexample.api;

import com.mttnow.forecastexample.entites.Forecast;
import com.mttnow.forecastexample.entites.Search;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by alahammad on 12/2/15.
 */
public interface ForecastApi {

    @GET("weather.ashx?num_of_days=5&cc=no&fx24=no&tp=24&format=json")
    Call<Forecast> getForecast(
            @Query("q") String country,
            @Query("key") String apiKey
    );


    @GET("search.ashx?format=json")
    Call<Search> searchForecast(
            @Query("q") String country,
            @Query("key") String apiKey);

}
