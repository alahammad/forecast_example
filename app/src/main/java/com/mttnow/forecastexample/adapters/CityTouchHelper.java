package com.mttnow.forecastexample.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mttnow.forecastexample.MainActivity;
import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.utils.DatabaseUtils;

/**
 * Created by alahammad on 12/4/15.
 */
public class CityTouchHelper extends ItemTouchHelper.SimpleCallback {

    private CitiesAdapter mCitiesAdapter;
    private Context mContext;

    public CityTouchHelper(CitiesAdapter citiesAdapter, Context context) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.mCitiesAdapter = citiesAdapter;
        this.mContext = context;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //TODO: Not implemented here
        return false;
    }


    @Override

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //Remove item
        final RecyclerView.ViewHolder holder = viewHolder;
        final int position = holder.getAdapterPosition();
        City city = mCitiesAdapter.getItem(holder.getAdapterPosition());
        final City original = new City(city.getId(), city.getCityName(), city.getTemp());
        DatabaseUtils.getInstance(mContext).deleteCity(city);
        mCitiesAdapter.notifyItemRemoved(holder.getAdapterPosition());

        Snackbar.make(viewHolder.itemView, "Are you sure to delete ?", Snackbar.LENGTH_LONG).setAction("Confirm", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCitiesAdapter.notifyItemInserted(position);
                DatabaseUtils.getInstance(mContext).createCity(original);
            }
        }).show();

//        mCitiesAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

    }

}