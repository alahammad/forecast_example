package com.mttnow.forecastexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mttnow.forecastexample.R;
import com.mttnow.forecastexample.entites.City;
import com.mttnow.forecastexample.entites.Data;

/**
 * Created by alahammad on 12/3/15.
 */
public final class CitiesAdapter extends RealmRecyclerViewAdapter<Data> {

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    private OnItemClickListener mItemClickListener;


    private class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvName, tvTemp;

        public EventViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_city_name);
            tvTemp = (TextView) view.findViewById(R.id.tv_temp);
            view.setOnClickListener(this);
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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_row, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        EventViewHolder evh = (EventViewHolder) viewHolder;
        Data city = getItem(i);
        evh.tvName.setText(city.getRequest().get(0).getQuery());
        evh.tvTemp.setText(city.getWeather().get(0).getMaxtempC());
    }

    /* The inner RealmBaseAdapter
     * view count is applied here.
     *
     * getRealmAdapter is defined in RealmRecyclerViewAdapter.
     */
    @Override
    public int getItemCount() {
        if (getRealmAdapter() != null) {
            return getRealmAdapter().getCount();
        }
        return 0;
    }
}