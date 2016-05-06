package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AddFuelActivity extends App
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final CoordinatorLayout clayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout_add_fuel);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add_fuel);
        if (fab != null)
        {
            fab.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    database.beginTransaction();
                    try
                    {
                        FuelItem fuel = createtFuelItemFromField();
                        database.copyToRealm(fuel);
                        Snackbar.make(clayout, "Aggiunto nuovo pieno.", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    } catch (Exception e)
                    {
                        Snackbar.make(clayout, "Errore nell'inserimento dei dati. Controllali!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                    database.commitTransaction();
                }
            });
        }
    }

    @NonNull
    private FuelItem createtFuelItemFromField()
    {

        EditText totalkm = (EditText) findViewById(R.id.edittext_total_km);
        EditText price = (EditText) findViewById(R.id.edittext_price);
        EditText liters = (EditText) findViewById(R.id.edittext_liters);
        EditText location = (EditText) findViewById(R.id.edittext_location);

        FuelItem fuel = new FuelItem();
        fuel.setTotalKm(Integer.parseInt(totalkm.getText().toString()));
        fuel.setPrice(Double.parseDouble(price.getText().toString()));
        fuel.setLiters(Double.parseDouble(liters.getText().toString()));
        fuel.setLocation(location.getText().toString());

        return fuel;
    }
}
