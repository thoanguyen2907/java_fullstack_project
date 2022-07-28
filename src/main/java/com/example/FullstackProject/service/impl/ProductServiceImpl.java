package com.example.FullstackProject.service.impl;

import com.example.FullstackProject.model.entity.Product;
import com.example.FullstackProject.repository.ProductRepository;
import com.example.FullstackProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    Calendar cal = Calendar.getInstance();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productID) {
        productRepository.deleteById(productID);
    }
    @Override
    public Optional<Product> getProductById(Long productID) {
        Optional<Product> productFound= Optional.ofNullable(productRepository.findById(productID).orElseThrow(() -> new IllegalStateException(
                "product with id " + " does not exist"
        )));
       return productFound;
    }

    @Override
    public void updateProduct(Product productDetail) {
        Product product = productRepository.findById(productDetail.getId()).orElseThrow(() -> new IllegalStateException(
                "product with id " + productDetail.getId() + " does not exist"
        ));
        if (productDetail.getName() != null && productDetail.getName().length() > 0 && !Objects.equals(product.getName(), productDetail.getName())) {
            product.setName(productDetail.getName());
        }
        if (productDetail.getCategory() != null && productDetail.getCategory().length() > 0 && !Objects.equals(productDetail.getCategory(), productDetail.getCategory())){
            product.setCategory(productDetail.getCategory());
        }
        if (productDetail.getBrand() != null && !Objects.equals(productDetail.getBrand(), productDetail.getBrand())) {
            product.setBrand(productDetail.getBrand());
        }
        if (productDetail.getDescription() != null && !Objects.equals(productDetail.getDescription(), productDetail.getDescription())) {
            product.setDescription(productDetail.getDescription());
        }
        if (productDetail.getDescription() != null && !Objects.equals(productDetail.getDescription(), productDetail.getDescription())) {
            product.setDescription(productDetail.getDescription());
        }
        if (productDetail.getCount_in_stock() != 0 && !Objects.equals(productDetail.getCount_in_stock(), productDetail.getCount_in_stock())) {
            productDetail.setCount_in_stock(productDetail.getCount_in_stock());
        }
        if (productDetail.getRating() != 0 && !Objects.equals(productDetail.getRating(), productDetail.getRating())) {
            productDetail.setRating(productDetail.getRating());
        }
        productDetail.setModifiedBy(dateFormat.format(cal.getTime()));
    }
}
