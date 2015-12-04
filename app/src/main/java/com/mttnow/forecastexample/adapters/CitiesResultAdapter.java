package com.mttnow.forecastexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.City;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alahammad on 12/4/15.
 */
public class CitiesResultAdapter extends RecyclerView.Adapter<CitiesResultAdapter.CityViewHolder> {


    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    private OnItemClickListener mItemClickListener;


    public class CityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.tv_city_name)
        TextView cityName;

        CityViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }


    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    City[] cityList;

    public CitiesResultAdapter(City[] cityList) {
        this.cityList = cityList;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_row, viewGroup, false);
        CityViewHolder cityViewHolder = new CityViewHolder(v);
        return cityViewHolder;
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.cityName.setText(cityList[position].getCityName());
    }

    @Override
    public int getItemCount() {
        return cityList.length;
    }


    public City getItem(int position) {
        return cityList[position];
    }
}
