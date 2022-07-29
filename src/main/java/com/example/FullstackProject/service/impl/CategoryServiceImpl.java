package com.example.FullstackProject.service.impl;

import com.example.FullstackProject.Converter.Converter;
import com.example.FullstackProject.model.entity.CategoryEntity;
import com.example.FullstackProject.model.entity.ProductEntity;
import com.example.FullstackProject.model.request.CategoryRequest;
import com.example.FullstackProject.model.response.CategoryResponse;
import com.example.FullstackProject.model.response.ProductResponse;
import com.example.FullstackProject.repository.CategoryRepository;
import com.example.FullstackProject.repository.ProductRepository;
import com.example.FullstackProject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final  CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return Converter.toList(categoryEntities, CategoryResponse.class);
    }

    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = Converter.toModel(categoryRequest, CategoryEntity.class);
        categoryRepository.save(categoryEntity);
        return Converter.toModel(categoryEntity, CategoryResponse.class);

    }

    @Override
    public CategoryResponse getCategoryById(Long categoryID) {
;          CategoryEntity categoryEntity = categoryRepository.findById(categoryID).orElseThrow(() -> new IllegalStateException(
            "category with id" + " does not exist"
        ));
        return Converter.toModel(categoryEntity, CategoryResponse.class);
    }

    @Override
    public void deleteCategory(Long categoryID) throws Exception {

      ProductEntity productEntity =  productRepository.findAll().stream().filter(
               pro ->
                   Objects.equals(pro.getCategory(), categoryID))
                    .findFirst()
                    .orElse(null);
                   if(null != productEntity){
                        throw new Exception("product is existed");
                   } else {
                       categoryRepository.deleteById(categoryID);
                   }
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryRequest, Long id) {
       CategoryEntity categoryEntity = categoryRepository.findById(id)
               .map(category -> {
                   category.setName(categoryRequest.getName());
                   return categoryRepository.save(category);
               }).orElseThrow(() -> new IllegalStateException(
                   "product with id " + id + " does not exist"
           ));
    return Converter.toModel(categoryEntity, CategoryResponse.class);
    }
}
