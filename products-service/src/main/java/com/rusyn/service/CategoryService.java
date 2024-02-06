package com.rusyn.service;

import com.rusyn.dto.CategoryDto;
import com.rusyn.entity.Category;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
}
