package com.rusyn.dto;

import com.rusyn.entity.Category;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
public class ProductDto {
    private String id;

    @NotEmpty
    @Size(min = 2, max = 50, message = "Product should have from 2 to 50 characters")
    private String name;

    private String categoryName;

    @NotEmpty
    @Size(min=10, message = "Description should have at least 10 characters")
    private String description;

    @NotNull
    @Min(0)
    private double cost;

    private String imageUrl;
    private double rating;
    private int quantity;
}
