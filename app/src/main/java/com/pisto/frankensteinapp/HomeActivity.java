package com.pisto.frankensteinapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

public class HomeActivity extends DrawerActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);

        configureFABAddFuel();
        configureFABHistoryFuel();
    }

    @Override
    public void onBackPressed()
    {
        System.exit(1);
    }

    private void launchAddFuelActivity()
    {
        Intent launchAddFuelActivity = new Intent(getApplicationContext(), AddFuelActivity.class);
        startActivity(launchAddFuelActivity);
    }

    private void launchHistoryFuelActivity()
    {
        Intent launchHistoryActivity = new Intent(getApplicationContext(), FuelHistoryActivity.class);
        startActivity(launchHistoryActivity);
    }

    private void configureFABAddFuel()
    {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null)
        {
            fab.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    launchAddFuelActivity();
                }
            });
        }
    }

    private void configureFABHistoryFuel()
    {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_history_fuel);
        if (fab != null)
        {
            fab.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    launchHistoryFuelActivity();
                }
            });
        }
    }
}
