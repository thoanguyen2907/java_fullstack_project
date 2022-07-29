package com.example.FullstackProject.service;

import com.example.FullstackProject.model.entity.CategoryEntity;
import com.example.FullstackProject.model.request.CategoryRequest;
import com.example.FullstackProject.model.response.CategoryResponse;
import com.example.FullstackProject.model.response.ProductResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    CategoryResponse addCategory(CategoryRequest category);

    CategoryResponse getCategoryById(Long categoryID);

    void deleteCategory(Long categoryID) throws Exception;

    CategoryResponse updateCategory(CategoryRequest categoryRequest, Long id);

}
