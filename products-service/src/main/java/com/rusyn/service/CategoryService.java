package com.rusyn.service;

import com.rusyn.dto.CategoryDto;
import com.rusyn.entity.Category;

public interface CategoryService {
    Category createCategory(CategoryDto categoryDto);
}
