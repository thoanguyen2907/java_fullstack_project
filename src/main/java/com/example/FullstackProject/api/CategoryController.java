package com.example.FullstackProject.api;

import com.example.FullstackProject.model.entity.Category;
import com.example.FullstackProject.model.entity.Product;
import com.example.FullstackProject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/category")
@RequiredArgsConstructor
public class CategoryController  {
    private  final CategoryService categoryService;
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @GetMapping(path = "{categoryId}")
    public Optional<Category> getCategoryById(@PathVariable("categoryId") Long categoryID) {
        return categoryService.getCategoryById(categoryID);
    }
    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @DeleteMapping(path = "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
    @PutMapping
    public void updateCategory(@RequestBody Category categoryDetail) {
        categoryService.updateCategory(categoryDetail);
    }
}
