package com.example.FullstackProject.api;

import com.example.FullstackProject.model.request.ProductRequest;
import com.example.FullstackProject.model.response.ProductResponse;
import com.example.FullstackProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<ProductResponse> productResponses = productService.getAllProducts();
        return ResponseEntity.ok(productResponses);
    }

    @GetMapping(path = "{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") Long productID) {
        ProductResponse productResponse = productService.getProductById(productID);
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.addProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id) {
        ProductResponse productResponse = productService.updateProduct(productRequest, id);
        return ResponseEntity.ok(productResponse);
    }

}
