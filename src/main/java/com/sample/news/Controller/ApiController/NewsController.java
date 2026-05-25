package com.sample.news.Controller.ApiController;

import com.sample.news.DTO.NewsDto;
import com.sample.news.DTO.ReadLogDto;
import com.sample.news.Service.CategoriesService;
import com.sample.news.Service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class NewsController {

    private final CategoriesService categoriesService;
    private final NewsService newsService;

    @GetMapping("/{id}")
    public List<NewsDto> news(@PathVariable("id") Integer categoryId) throws Exception {
        var url = categoriesService.get(categoryId).getRssUrl();

        return newsService.getNewsList(url);
    }

    @PostMapping("/read")
    public void createNewsReadLog(@RequestBody ReadLogDto readLog) {
        newsService.createNewsReadLog(readLog.getArticleId());
    }
}
