package com.example.ecommerce.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequestDTO {
    private String name;
    private String description;
    private Double price;
    private Integer category;
    private Integer quantity;
}
