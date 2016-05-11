package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FuelHistoryActivity extends App
{

    private RecyclerView historyRecyclerView;
    private LinearLayoutManager layoutManager;
    private HistoryViewAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database.beginTransaction();

        historyRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_history_fuel);
        historyRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        historyRecyclerView.setLayoutManager(layoutManager);
        historyAdapter = new HistoryViewAdapter(database.where(FuelItem.class).findAll());
        historyRecyclerView.setAdapter(historyAdapter);

        database.commitTransaction();

        configureFAB();
    }

    private void configureFAB()
    {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
