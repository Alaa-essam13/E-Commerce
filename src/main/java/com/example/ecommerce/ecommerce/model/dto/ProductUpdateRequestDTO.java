package com.example.ecommerce.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequestDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int stock;
}
