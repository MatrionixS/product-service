package com.rusyn.mapper;

import com.rusyn.dto.ProductResponse;
import com.rusyn.model.Product;


public class ProductMapper {

    public static ProductResponse toDto(Product product) {
        ProductResponse productResponse = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        return productResponse;
    }
}
