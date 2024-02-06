package com.rusyn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ErrorDto {
    private Date date;
    private String message;
    private String description;
}
