package com.mttnow.forecastexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.entites.Data;
import com.mttnow.forecastexample.utils.DatabaseUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alahammad on 12/3/15.
 */
public final class CitiesAdapter extends RealmRecyclerViewAdapter<City> {

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    private OnItemClickListener mItemClickListener;
    private Context mContext;

    public CitiesAdapter(Context mContext) {
        this.mContext = mContext;
    }

    class CitiesViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tv_city_name)
         TextView tvName;

        @Bind(R.id.tv_temp)
         TextView tvTemp;

         @Bind(R.id.delete)
         Button delete;

        public CitiesViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }


    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_row, parent, false);
        return new CitiesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,final int position) {
        CitiesViewHolder vh = (CitiesViewHolder) viewHolder;
        final City city = getItem(position);
        vh.tvName.setText(city.getCityName());
        vh.tvTemp.setText(city.getTemp());
        vh.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(view, position);
                }
            }
        });
        vh.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyItemRemoved(position);
                DatabaseUtils.getInstance(mContext).deleteCity(city);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (getRealmAdapter() != null) {
            return getRealmAdapter().getCount();
        }
        return 0;
    }
}