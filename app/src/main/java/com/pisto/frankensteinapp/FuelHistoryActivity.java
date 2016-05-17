package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FuelHistoryActivity extends DrawerActivity
{

    private RecyclerView historyRecyclerView;
    private LinearLayoutManager layoutManager;
    private HistoryViewAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_fuel_history, frameLayout);

        database.beginTransaction();

        historyRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_history_fuel);
        historyRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        historyRecyclerView.setLayoutManager(layoutManager);
        historyAdapter = new HistoryViewAdapter(database.where(FuelItem.class).findAll());
        historyRecyclerView.setAdapter(historyAdapter);

        database.commitTransaction();
    }
}
