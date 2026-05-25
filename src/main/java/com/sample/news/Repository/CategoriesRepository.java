package com.sample.news.Repository;

import com.sample.news.Entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Categories findById(Integer id);

    List<Categories> findAll();
}