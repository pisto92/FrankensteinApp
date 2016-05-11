package com.pisto.frankensteinapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends AppCompatActivity
{
    Toolbar toolbar;
    Realm database;
    android.view.ViewGroup frameLayout;

    String titles[] = {"Statistiche", "Promemoria", "Spese", "Informazioni"};
    int icons[] = {
            R.mipmap.icon_stats,
            R.mipmap.icon_memo,
            R.mipmap.icon_money,
            R.mipmap.icon_info};

    String carName = "Alfa 147 1.9 JTDM";

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_drawer);
        frameLayout = (FrameLayout)  findViewById(R.id.content_frame);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database = Realm.getInstance(new RealmConfiguration.Builder(getApplicationContext()).name("carStats.realm").schemaVersion(0).deleteRealmIfMigrationNeeded().build());

        configureDrawer();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        super.setContentView(layoutResID);
        configureDrawer();
    }

    private void configureDrawer()
    {
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new DrawerRowAdapter(titles, icons, carName);
        mRecyclerView.setAdapter(mAdapter);

        final GestureDetector mGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener()
        {

            @Override
            public boolean onSingleTapUp(MotionEvent e)
            {
                return true;
            }

        });

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener()
        {

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)
            {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (child != null && mGestureDetector.onTouchEvent(motionEvent))
                {
                    Drawer.closeDrawers();
                    int itemClicked = recyclerView.getChildAdapterPosition(child);
                    switch (itemClicked)
                    {
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            launchMemoActivity();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)
            {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept)
            {

            }
        });

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.app_name, R.string.app_name)
        {

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }
        };
        Drawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void launchMemoActivity()
    {
        Intent launchMemoActivity = new Intent(getApplicationContext(), MemoActivity.class);
        startActivity(launchMemoActivity);
    }
}
