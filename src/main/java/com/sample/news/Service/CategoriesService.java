package com.sample.news.Service;

import com.sample.news.DTO.CategoriesDto;
import com.sample.news.Entity.Categories;
import com.sample.news.Enum.ErrorCode;
import com.sample.news.Exception.ErrorException;
import com.sample.news.Repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    /**
     * 카테고리 단일 조회
     * */
    public CategoriesDto get(Integer categoryId) {
        try {
            Categories categories = categoriesRepository.findById(categoryId);

            return new CategoriesDto(
                    categories.getId(),
                    categories.getName(),
                    categories.getRssUrl()
            );
        } catch (ErrorException e) {
            Map<String, Object> logData = new HashMap<>();
            logData.put("categoryId", categoryId);
            throw new ErrorException(ErrorCode.CATEGORIES_NOT_FOUND, logData);
        }
    }

    /**
     * 카테고리 목록 조회
     * */
    public List<CategoriesDto> getCategoryList() {
        try {
            return categoriesRepository.findAll()
                    .stream()
                    .map(category -> new CategoriesDto(
                            category.getId(),
                            category.getName(),
                            category.getRssUrl()
                    ))
                    .toList();
        } catch (ErrorException e) {
            throw new ErrorException(ErrorCode.CATEGORIES_NOT_FOUND, null);
        }
    }
}
