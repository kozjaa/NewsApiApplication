package com.news.NewsApi.domain.repository;


import com.news.NewsApi.domain.Articles;
import com.news.NewsApi.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class NewsRepository {

    @Autowired
    private RestTemplate restTemplate;

    private String apiUrl = "https://newsapi.org/v2/top-headlines?";

    private String searchApiUrl = "https://newsapi.org/v2/everything?q=";

    private String apiKey = "&apiKey=5b7f6c7ee2f5468d9ad9b62093944571";

    private String pageSize = "&pageSize=100";

    public News[] getNewsByCountryAndCategory(String country, String category) {
        String url = apiUrl + "country="+country+"&category=" + category + pageSize + apiKey;
        ResponseEntity<Articles<News>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>(){});
        News[] news = responseEntity.getBody().getArray();
        return news;
    }

    public News[] getNewsByCategory(String category) {
        String url = apiUrl + "category=" + category + pageSize + apiKey;
        ResponseEntity<Articles<News>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>(){});
        News[] news = responseEntity.getBody().getArray();
        return news;
    }

    public News[] getNewsBySearchRequest(String search) {
        String url = searchApiUrl + search + pageSize + apiKey;
        ResponseEntity<Articles<News>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>(){});
        News[] news = responseEntity.getBody().getArray();
        return news;
    }

    public News[] home() {
        String url = apiUrl + "category=general&country=us" + pageSize + apiKey;
        ResponseEntity<Articles<News>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>(){});
        News[] news = responseEntity.getBody().getArray();
        return news;
    }
}
