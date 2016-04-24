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

    public void setFirstLine(String firstLine)
    {
        this.firstLine = firstLine;
    }

    public String getSecondLine()
    {
        return secondLine;
    }

    public void setSecondLine(String secondLine)
    {
        this.secondLine = secondLine;
    }
}
