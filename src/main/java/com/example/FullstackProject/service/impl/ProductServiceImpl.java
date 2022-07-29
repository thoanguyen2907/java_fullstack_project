package com.example.FullstackProject.service.impl;

import com.example.FullstackProject.Converter.Converter;
import com.example.FullstackProject.model.entity.CategoryEntity;
import com.example.FullstackProject.model.entity.ProductEntity;
import com.example.FullstackProject.model.request.ProductRequest;
import com.example.FullstackProject.model.response.ProductResponse;
import com.example.FullstackProject.repository.CategoryRepository;
import com.example.FullstackProject.repository.ProductRepository;
import com.example.FullstackProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return Converter.toList(productEntities, ProductResponse.class);
    }


    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        ProductEntity productEntity = Converter.toModel(productRequest, ProductEntity.class);
        CategoryEntity category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new IllegalStateException(
                        "category with id " + productRequest.getCategoryId() + " does not exist"));
        productEntity.setCategory(category);
        productRepository.save(productEntity);
        return Converter.toModel(productEntity, ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest, Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .map(product -> {
                    product.setName(productRequest.getName());
                    product.setBrand(productRequest.getBrand());
                    product.setDescription(productRequest.getDescription());
                    product.setCount_in_stock(productRequest.getCount_in_stock());
                    product.setRating(productRequest.getRating());
                    return productRepository.save(product);
                }).orElseThrow(() -> new IllegalStateException(
                        "product with id " + id + " does not exist"));
        return Converter.toModel(productEntity, ProductResponse.class);
    }
    @Override
    public void deleteProduct(Long productID) {
        productRepository.deleteById(productID);
    }

    @Override
    public ProductResponse getProductById(Long productID) {
        ProductEntity productEntity = productRepository.findById(productID).orElseThrow(() -> new IllegalStateException(
                "product with id " + " does not exist"
        ));
<<<<<<< HEAD
        return Converter.toModel(productEntity, ProductResponse.class);
=======
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
>>>>>>> 7499377b95062591327ddae2ee4f798fbcf11c98
    }

}
