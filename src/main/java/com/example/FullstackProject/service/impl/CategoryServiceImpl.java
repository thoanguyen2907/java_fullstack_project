package com.example.FullstackProject.service.impl;

import com.example.FullstackProject.model.entity.Category;
import com.example.FullstackProject.model.entity.Product;
import com.example.FullstackProject.repository.CategoryRepository;
import com.example.FullstackProject.repository.ProductRepository;
import com.example.FullstackProject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final  CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long categoryID) {
;          Optional<Category> category = Optional.ofNullable(categoryRepository.findById(categoryID).orElseThrow(() -> new IllegalStateException(
                "category with id " + " does not exist"
        )));
        return category;
    }

    @Override
    public void deleteCategory(Long categoryID) {
        categoryRepository.deleteById(categoryID);
    }

    @Override
    public void updateCategory(Category categoryDetail) {
        Category category = categoryRepository.findById(categoryDetail.getId()).orElseThrow(() -> new IllegalStateException(
                "category with id " + categoryDetail.getId() + " does not exist"
        ));
        System.out.println(category);
        System.out.println("categoryDetail");
        System.out.println( categoryDetail);
        if (categoryDetail.getName() != null && categoryDetail.getName().length() > 0 && !Objects.equals(category.getName(), categoryDetail.getName())) {
            category.setName(categoryDetail.getName());
        }

    }
}
