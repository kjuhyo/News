package com.sample.news.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "readlog")
@Getter
@NoArgsConstructor
public class ReadLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "article_id")
    private String articleID;

    @Column(name = "created_date")
    private String createdDate;

    public ReadLog(String articleId, String createdDate) {
        articleID = articleId;
        this.createdDate = createdDate;
    }
}
