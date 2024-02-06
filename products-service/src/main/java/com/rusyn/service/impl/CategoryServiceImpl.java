package com.rusyn.service.impl;

import com.rusyn.dto.CategoryDto;
import com.rusyn.entity.Category;
import com.rusyn.exception.CategoryNotFoundException;
import com.rusyn.exception.ProductNotFoundException;
import com.rusyn.repository.CategoryRepository;
import com.rusyn.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);

        return CategoryDto.builder()
                .name(category.getName()).build();
    }

}
