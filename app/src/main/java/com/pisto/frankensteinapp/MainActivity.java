package com.pisto.frankensteinapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

public class MainActivity extends App
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureFAB();
    }

    private void launchAddFuelActivity()
    {
        Intent launchAddFuelActivity = new Intent(getApplicationContext(), AddFuelActivity.class);
        startActivity(launchAddFuelActivity);
    }

    private void configureFAB()
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
}
