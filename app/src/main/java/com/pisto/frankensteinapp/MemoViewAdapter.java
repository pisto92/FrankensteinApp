package com.pisto.frankensteinapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MemoViewAdapter extends RecyclerView.Adapter<MemoViewAdapter.MemoViewHolder>
{

    private ArrayList<MemoItem> dataset;

    public static class MemoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView firstLine;
        TextView secondLine;

        public MemoViewHolder(View itemView)
        {
            super(itemView);
            firstLine = (TextView) itemView.findViewById(R.id.textview_first_line);
            secondLine = (TextView) itemView.findViewById(R.id.textview_second_line);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
        }
    }

    public MemoViewAdapter(ArrayList<MemoItem> dataset)
    {
        this.dataset = dataset;
    }

    @Override
    public MemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_memo, parent, false);
        MemoViewHolder dataObjectHolder = new MemoViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(MemoViewHolder holder, int position)
    {
        holder.firstLine.setText(dataset.get(position).getFirstLine());
        holder.secondLine.setText(dataset.get(position).getSecondLine());
    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }
}
