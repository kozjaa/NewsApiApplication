package com.news.NewsApi.controller;


import com.news.NewsApi.domain.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(value= "/news/{country}/{category}")
    public String getNewsByCountryAndCategory(Model model, @PathVariable("country") String country
            , @PathVariable("category") String category) {
        model.addAttribute("news", newsRepository.getNewsByCountryAndCategory(country, category));
        model.addAttribute("country", "Country: " + country);
        model.addAttribute("category", "Category: " + category);
        return "index";
    }

    @RequestMapping(value= "/news/categories/{category}")
    public String getNewsByCategory(Model model, @PathVariable("category") String category) {
        model.addAttribute("news", newsRepository.getNewsByCategory(category));
        model.addAttribute("category", "Category: " + category);
        return "index";
    }

    @RequestMapping(value= "/news/search")
    public String getNewsBySearch(Model model, @RequestParam(value = "search", required = false) String search) {
        if (search.trim().equals("")) {
            model.addAttribute("news", newsRepository.home());
            return "index";}
        else {
            model.addAttribute("news", newsRepository.getNewsBySearchRequest(search));
            model.addAttribute("result", "Results for: " + search);
            return "index";}
    }

    @RequestMapping("/news")
    public String home(Model model) {
        model.addAttribute("news", newsRepository.home());
        return "index";
    }
}
