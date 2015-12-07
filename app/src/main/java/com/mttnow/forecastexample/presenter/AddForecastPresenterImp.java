package com.mttnow.forecastexample.presenter;

import android.content.Context;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.adapters.CitiesResultAdapter;
import com.mttnow.forecastexample.api.ApiGenerator;
import com.mttnow.forecastexample.api.ForecastApi;
import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.entites.Search;
import com.mttnow.forecastexample.utils.DialogsUtils;
import com.mttnow.forecastexample.view.AddForecastView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by alahammad on 12/4/15.
 */
public class AddForecastPresenterImp implements AddForecastPresenter {


    AddForecastView addForecastView;


    public AddForecastPresenterImp(AddForecastView addForecastView) {
        this.addForecastView = addForecastView;
    }

    @Override
    public void searchCityForecast(String city, final Context context) {
        addForecastView.startLoading();
        ForecastApi retrofit = ApiGenerator.createService(ForecastApi.class);
        Call<Search> call = retrofit.searchForecast(city, context.getString(R.string.api_key));
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Response<Search> response, Retrofit retrofit) {
                addForecastView.stopLoading();
                if (response.body().getData()==null||response.body().getData().getError()==null) {
                    if (response.isSuccess()) {
                        City[] result = new City[response.body().getSearch_api().getResult().length];
                        for (int i = 0; i < response.body().getSearch_api().getResult().length; i++) {
                            result[i] = new City(response.body().getSearch_api().getResult()[i].getAreaName()[0].getValue() + ", " + response.body().getSearch_api().getResult()[i].getCountry()[0].getValue());
                        }

                        CitiesResultAdapter adapter = new CitiesResultAdapter(result);
                        addForecastView.loadComplete(adapter);

                    } else {
                        DialogsUtils.getInstance().showDialog(context, context.getString(R.string.api_error));
                    }
                }else{
                    // show api error
                    com.mttnow.forecastexample.entites.Error error = response.body().getData().getError().get(0);
                    DialogsUtils.getInstance().showDialog(context, error.getMsg());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                addForecastView.stopLoading();
                DialogsUtils.getInstance().showDialog(context, context.getString(R.string.api_error));
            }
        });

    }
}
