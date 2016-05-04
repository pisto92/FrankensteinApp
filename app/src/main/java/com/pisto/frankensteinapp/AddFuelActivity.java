package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import io.realm.RealmResults;

public class AddFuelActivity extends App
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add_fuel);
        if (fab != null)
        {
            fab.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    try
                    {
                        EditText totalkm = (EditText) findViewById(R.id.edittext_total_km);
                        FuelItem fuel = new FuelItem();
                        fuel.setTotalKm(Integer.parseInt(totalkm.getText().toString()));
                        fuel.setPrice(50);
                        fuel.setLiters(70);
                        fuel.setLocation("Fornasette");
                        database.beginTransaction();
                        database.copyToRealm(fuel);
                        database.commitTransaction();

                        RealmResults<FuelItem> resultsFuel = database.where(FuelItem.class).findAll();
                        Snackbar.make(view, resultsFuel.size() + " Elementi nel DB", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    } catch (Exception e)
                    {
                        database.commitTransaction();
                        Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    }
                }
            });
        }
    }
}
