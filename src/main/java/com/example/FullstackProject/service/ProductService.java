package com.example.FullstackProject.service;

import com.example.FullstackProject.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    void addProduct(Product product);

    Optional<Product> getProductById(Long productID);

    void deleteProduct(Long productID);

    void updateProduct(Product productDetail);
}
