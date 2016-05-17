package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MemoActivity extends DrawerActivity
{

    private RecyclerView memoRecyclerView;
    private RecyclerView.Adapter memoAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_memo, frameLayout);

        configureMemoRecyclerView();
        configureFAB();
    }

    private void configureMemoRecyclerView()
    {
        memoRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_memo);
        memoRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        memoRecyclerView.setLayoutManager(layoutManager);
        memoAdapter = new MemoViewAdapter(getDataSet());
        memoRecyclerView.setAdapter(memoAdapter);
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
                    Snackbar.make(view, "Azione non ancora definita", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            });
        }
    }

    private ArrayList<MemoItem> getDataSet()
    {
        ArrayList results = new ArrayList<MemoItem>();
        for (int index = 0; index < 20; index++)
        {
            MemoItem obj = new MemoItem("Some Primary Text " + index,"Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }

}
