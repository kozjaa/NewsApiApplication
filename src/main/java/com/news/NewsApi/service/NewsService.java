package com.news.NewsApi.service;

import com.news.NewsApi.domain.News;
import com.news.NewsApi.domain.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public News[] getNewsByCountryAndCategory(String country, String category)
    {
        return newsRepository.getNewsByCountryAndCategory(country, category);
    }

    public News[] getNewsByCategory(String category)
    {
        return newsRepository.getNewsByCategory(category);
    }

    public News[] getNewsBySearchRequest(String search)
    {
        return newsRepository.getNewsBySearchRequest(search);
    }

    public News[] home()
    {
       return newsRepository.home();
    }
}
