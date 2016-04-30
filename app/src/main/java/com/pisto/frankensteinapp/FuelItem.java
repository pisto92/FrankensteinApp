package com.pisto.frankensteinapp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FuelItem extends RealmObject
{
    @PrimaryKey
    private int totalKm;

    private double price;
    private double liters;
    private String location;

    public FuelItem()
    {
    }

    public void setTotalKm(int totalKm)
    {
        this.totalKm = totalKm;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setLiters(double liters)
    {
        this.liters = liters;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public int getTotalKm()
    {
        return totalKm;
    }

    public double getPrice()
    {
        return price;
    }

    public double getLiters()
    {
        return liters;
    }

    public String getLocation()
    {
        return location;
    }
}
