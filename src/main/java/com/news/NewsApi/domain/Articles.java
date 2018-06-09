package com.news.NewsApi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Articles<News> {

    private News[] array;

    @JsonProperty("articles")
    public News[] getArray() {
        return array;
    }

    public void setArray(News[] array) {
        this.array = array;
    }
}
