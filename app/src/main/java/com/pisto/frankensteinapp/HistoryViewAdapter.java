package com.pisto.frankensteinapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import io.realm.RealmResults;

public class HistoryViewAdapter extends RecyclerView.Adapter<HistoryViewAdapter.HistoryViewHolder>
{
    private final RealmResults<FuelItem> dataset;
    NumberFormat formatter = new DecimalFormat("#0.00");
    NumberFormat formatterPriceLiter = new DecimalFormat("#0.000");
    public class HistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {


        private TextView price;
        private TextView liters;
        private TextView location;
        private TextView totalKm;
        private TextView priceLiter;

        public HistoryViewHolder(View itemView)
        {
            super(itemView);
            totalKm = (TextView) itemView.findViewById(R.id.cardview_textview_total_km);
            price = (TextView) itemView.findViewById(R.id.cardview_textview_price);
            liters = (TextView) itemView.findViewById(R.id.cardview_textview_liters);
            location = (TextView) itemView.findViewById(R.id.cardview_textview_location);
            priceLiter = (TextView) itemView.findViewById(R.id.cardview_textview_price_liter);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {

        }
    }

    public HistoryViewAdapter(RealmResults<FuelItem> dataset)
    {
        this.dataset = dataset;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fuel, parent, false);
        HistoryViewHolder dataObjectHolder = new HistoryViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position)
    {
        double price = dataset.get(position).getPrice();
        double liters = dataset.get(position).getLiters();

        holder.totalKm.setText(String.valueOf(dataset.get(position).getTotalKm()));
        holder.price.setText(formatter.format(price));
        holder.liters.setText(formatter.format(liters));
        holder.location.setText(dataset.get(position).getLocation());

        holder.priceLiter.setText(formatterPriceLiter.format(price/liters));
    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }
}
