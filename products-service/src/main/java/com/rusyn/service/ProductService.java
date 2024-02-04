package com.rusyn.service;

import com.rusyn.dto.ProductDto;
import com.rusyn.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product getProductById(String id);
    Product getProductByName(String name);
    List<Product> getProducts();
    Product createProduct(ProductDto productDto);
    Product updateProduct(ProductDto productDto, String productId);
    void deleteProduct(String productId);
}
