package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;


public class FuelHistoryFragment extends Fragment
{

    private Realm database;
    private RecyclerView historyRecyclerView;
    private LinearLayoutManager layoutManager;
    private HistoryViewAdapter historyAdapter;


    public FuelHistoryFragment(Realm database)
    {
        this.database = database;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        getHistoryFuelData(rootView);

        return rootView;
    }

    private void getHistoryFuelData(View rootView)
    {
        database.beginTransaction();
        populateRecyclerView(rootView, database);
        database.commitTransaction();
    }

    private void populateRecyclerView(View rootView, Realm database)
    {
        historyRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_history_fuel);
        historyRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        historyRecyclerView.setLayoutManager(layoutManager);
        historyAdapter = new HistoryViewAdapter(database.where(FuelItem.class).findAll());
        historyRecyclerView.setAdapter(historyAdapter);
    }

}