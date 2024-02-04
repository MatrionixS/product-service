package com.rusyn.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class CategoryDto {
    private String id;

    @NotEmpty
    private String name;
}
