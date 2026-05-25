package com.sample.news.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewsDto {

    private String title;
    private String link;
    private String description;
    private String pubDate;
    private String creator;
    private Boolean isRead;

}