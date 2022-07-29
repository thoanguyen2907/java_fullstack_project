package com.example.FullstackProject.service;

import com.example.FullstackProject.model.entity.ProductEntity;
import com.example.FullstackProject.model.request.ProductRequest;
import com.example.FullstackProject.model.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAllProducts();


    ProductResponse getProductById(Long productID);

    void deleteProduct(Long productID);


    ProductResponse addProduct(ProductRequest productRequest);

    ProductResponse updateProduct(ProductRequest productRequest, Long id);
}
