package com.sample.news.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReadLogDto {

    private Integer id;

    private String articleId;

    private String createdDate;
}
