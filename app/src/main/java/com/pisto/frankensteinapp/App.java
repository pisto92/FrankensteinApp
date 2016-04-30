package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends AppCompatActivity
{
    Toolbar toolbar;
    Realm database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        database = Realm.getInstance(new RealmConfiguration.Builder(getApplicationContext()).name("carStats.realm").schemaVersion(0).deleteRealmIfMigrationNeeded().build());
    }
}
