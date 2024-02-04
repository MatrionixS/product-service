package com.rusyn.service.impl;

import com.rusyn.dto.ProductDto;
import com.rusyn.entity.Category;
import com.rusyn.entity.Product;
import com.rusyn.exception.CategoryNotFoundException;
import com.rusyn.exception.ProductNotFoundException;
import com.rusyn.repository.CategoryRepository;
import com.rusyn.repository.ProductRepository;
import com.rusyn.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findProductByName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product with this name: " + name + " does not exist"));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Category category = categoryRepository.findByName(productDto.getCategoryName())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCost(productDto.getCost());
        product.setCategory(category);
        product.setQuantity(productDto.getQuantity());
        product.setImageUrl(productDto.getImageUrl());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductDto productDto, String productId) {
        Product toBeUpdated = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));

        Category category = categoryRepository.findByName(productDto.getCategoryName())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        toBeUpdated.setName(productDto.getName());
        toBeUpdated.setDescription(productDto.getDescription());
        toBeUpdated.setCost(productDto.getCost());
        toBeUpdated.setCategory(category);
        toBeUpdated.setQuantity(productDto.getQuantity());
        toBeUpdated.setImageUrl(productDto.getImageUrl());

        productRepository.save(toBeUpdated);

        return toBeUpdated;
    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

}
