package com.delta.Deltafolio.controller;

import com.delta.Deltafolio.dto.NewsArticleDTO;
import com.delta.Deltafolio.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<NewsArticleDTO>> getStockNews() {
        List<NewsArticleDTO> articles = newsService.getStockNews();
        return ResponseEntity.ok(articles);
    }
}
