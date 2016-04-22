package com.pisto.frankensteinapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerRowAdapter extends RecyclerView.Adapter<DrawerRowAdapter.ViewHolder>
{

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String titles[];
    private int icons[];

    private String carModel;

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        int holderId;

        TextView textView;
        TextView name;
        ImageView icon;

        public ViewHolder(View itemView, int ViewType)
        {
            super(itemView);

            if (ViewType == TYPE_ITEM)
            {
                icon = (ImageView) itemView.findViewById(R.id.rowIcon);
                textView = (TextView) itemView.findViewById(R.id.rowText);
                holderId = 1;
            } else
            {
                name = (TextView) itemView.findViewById(R.id.name);
                holderId = 0;
            }
        }
    }

    public DrawerRowAdapter(String titles[], int icons[], String carModel)
    {
        this.titles = titles;
        this.carModel = carModel;
        this.icons = icons;
    }

    @Override
    public DrawerRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (viewType == TYPE_ITEM)
        {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_itemrow, parent, false);
            ViewHolder viewHolderItem = new ViewHolder(item, viewType);
            return viewHolderItem;
        } else if (viewType == TYPE_HEADER)
        {
            View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_header, parent, false);
            ViewHolder viewHolderHeader = new ViewHolder(holder, viewType);
            return viewHolderHeader;
        }
        return null;
    }

    public void onBindViewHolder(DrawerRowAdapter.ViewHolder holder, int position)
    {
        if (holder.holderId == 1)
        {
            holder.icon.setImageResource(icons[position - 1]);
            holder.textView.setText(titles[position - 1]);
        } else
        {
            holder.name.setText(carModel);
        }
    }

    @Override
    public int getItemCount()
    {
        return titles.length + 1;
    }

    @Override
    public int getItemViewType(int position)
    {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position)
    {
        return position == 0;
    }
}
