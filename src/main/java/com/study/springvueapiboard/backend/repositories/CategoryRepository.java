package com.study.springvueapiboard.backend.repositories;

import com.study.springvueapiboard.backend.dtos.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Category repository.
 */
@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final CategoryMapper categoryMapper;

    /**
     * 카테고리 목록을 반환해주는 메서드
     *
     * @return List<Category> 카테고리 List
     */
    public List<CategoryDto> getCategoryList() {
        return categoryMapper.getCategoryList();
    }
}
