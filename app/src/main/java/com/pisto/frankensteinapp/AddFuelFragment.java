package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import io.realm.Realm;


public class AddFuelFragment extends Fragment
{

    private final Realm database;
    FloatingActionButton fab;
    CoordinatorLayout clayout;

    public AddFuelFragment(Realm _database)
    {
        database = _database;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        clayout = (CoordinatorLayout) rootView.findViewById(R.id.coordinator_layout_add_fuel);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab_add_fuel);

        configureFabAddFuel();

        return rootView;
    }

    private void configureFabAddFuel()
    {
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

        EditText totalkm = (EditText) getView().findViewById(R.id.edittext_total_km);
        EditText price = (EditText) getView().findViewById(R.id.edittext_price);
        EditText liters = (EditText) getView().findViewById(R.id.edittext_liters);
        EditText location = (EditText) getView().findViewById(R.id.edittext_location);

        FuelItem fuel = new FuelItem();
        fuel.setTotalKm(Integer.parseInt(totalkm.getText().toString()));
        fuel.setPrice(Double.parseDouble(price.getText().toString()));
        fuel.setLiters(Double.parseDouble(liters.getText().toString()));
        fuel.setLocation(location.getText().toString());

        return fuel;
    }

}