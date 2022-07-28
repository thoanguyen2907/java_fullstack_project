package com.example.FullstackProject.api;

import com.example.FullstackProject.model.entity.Product;
import com.example.FullstackProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping(path = "{productId}")
    public Optional<Product> getProductById(@PathVariable("productId") Long productID) {
        return productService.getProductById(productID);
    }
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping
    public void updateStudent(@RequestBody Product productDetail) {
        productService.updateProduct(productDetail);
    }

}
