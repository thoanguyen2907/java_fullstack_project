package com.example.FullstackProject.service;

import com.example.FullstackProject.model.entity.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();

    void addCategory(Category category);

    Optional<Category> getCategoryById(Long categoryID);

    void deleteCategory(Long categoryID);

    void updateCategory(Category categoryDetail);
}
