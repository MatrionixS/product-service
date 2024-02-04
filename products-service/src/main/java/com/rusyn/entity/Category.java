package com.rusyn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    private String id;
    private String name;
}
