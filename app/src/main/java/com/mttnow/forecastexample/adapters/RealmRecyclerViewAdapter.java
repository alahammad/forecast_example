package com.mttnow.forecastexample.adapters;

/**
 * Created by alahammad on 12/3/15.
 */

import android.support.v7.widget.RecyclerView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;




/**
 * source :  http://gradlewhy.ghost.io/realm-results-with-recyclerview/
 * Wrapper class that allows a RealmBaseAdapter instance to serve
 * as the data source for a RecyclerView.Adapter.
 */
public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter {
    private RealmBaseAdapter<T> realmBaseAdapter;

    /* getItemCount() is not implemented in this class
     * This is left to concrete implementations */

    public void setRealmAdapter(RealmBaseAdapter<T> realmAdapter) {
        realmBaseAdapter = realmAdapter;
    }

    public T getItem(int position) {
        return realmBaseAdapter.getItem(position);
    }

    public RealmBaseAdapter<T> getRealmAdapter() {
        return realmBaseAdapter;
    }


}