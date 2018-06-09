package com.news.NewsApi.domain.repository;


import com.news.NewsApi.domain.Articles;
import com.news.NewsApi.domain.News;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class NewsRepository {

    RestTemplate restTemplate = new RestTemplate();

    public News[] getNewsByCountryAndCategory(String country, String category)
    {
        String url = "https://newsapi.org/v2/top-headlines?country="+country+"&category="+category+
                "&pageSize=100&apiKey=5b7f6c7ee2f5468d9ad9b62093944571";

        ResponseEntity<Articles<News>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>(){});

        News[] news = responseEntity.getBody().getArray();

        return news;
    }

    public News[] getNewsByCategory(String category)
    {
        String url = "https://newsapi.org/v2/top-headlines?category="+category+
                "&pageSize=100&apiKey=5b7f6c7ee2f5468d9ad9b62093944571";

        ResponseEntity<Articles<News>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>(){});

        News[] news = responseEntity.getBody().getArray();

        return news;
    }

    public News[] getNewsBySearchRequest(String search)
    {
        String url = "https://newsapi.org/v2/everything?q=" +search+
                "&pageSize=100&apiKey=5b7f6c7ee2f5468d9ad9b62093944571";

        ResponseEntity<Articles<News>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>(){});

        News[] news = responseEntity.getBody().getArray();

        return news;
    }

    public News[] home()
    {
        String url = "https://newsapi.org/v2/top-headlines?category=general&country=us" +
                "&pageSize=100&apiKey=5b7f6c7ee2f5468d9ad9b62093944571";

        ResponseEntity<Articles<News>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>(){});

        News[] news = responseEntity.getBody().getArray();

        return news;
    }
}
