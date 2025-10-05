package com.example.ecommerce.ecommerce.lib.test;

import lombok.Data;

@Data
public class ProductFilter {
    private Boolean active;
    private String category;
    private Double minPrice;
    private Double maxPrice;
    private String search;
}
