package com.rusyn.service;

import com.rusyn.dto.ProductDto;
import com.rusyn.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    boolean productExists(String name);
    ProductDto getProductById(String id);
    List<Product> getProducts();
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, String productId);
    void deleteProduct(String productId);
}
