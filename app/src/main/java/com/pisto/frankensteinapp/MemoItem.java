package com.pisto.frankensteinapp;

public class MemoItem
{
    private String firstLine;
    private String secondLine;

    public MemoItem(String text1, String text2)
    {
        firstLine = text1;
        secondLine = text2;
    }

    public String getFirstLine()
    {
        return firstLine;
    }

    public String getSecondLine()
    {
        return secondLine;
    }
}
