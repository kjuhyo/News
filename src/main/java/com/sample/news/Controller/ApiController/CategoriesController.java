package com.sample.news.Controller.ApiController;

import com.sample.news.DTO.CategoriesDto;
import com.sample.news.Service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    @GetMapping("")
    public List<CategoriesDto> categories() {
        return categoriesService.getCategoryList();
    }
}
