package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AddFuelActivity extends App {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Aggiungi pieno");
        setSupportActionBar(toolbar);
    }
}
