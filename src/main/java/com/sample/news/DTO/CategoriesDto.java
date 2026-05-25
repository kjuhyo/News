package com.sample.news.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoriesDto {

    private Integer id;

    private String name;

    private String rssUrl;
}
