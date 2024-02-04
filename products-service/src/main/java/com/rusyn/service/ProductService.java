package com.rusyn.service;

import com.rusyn.dto.ProductRequest;
import com.rusyn.dto.ProductResponse;
import com.rusyn.model.Product;
import com.rusyn.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import com.rusyn.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::toDto).toList();
    }
 }
