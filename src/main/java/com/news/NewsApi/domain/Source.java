package com.news.NewsApi.domain;

public class Source {

    public Source()
    {

    }

    private String name;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
