package com.example.ecommerce.ecommerce.model.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum ProductSortBy {
    PRICE("price"),
    NEWEST("newest"),
    ;

    private String value;

}
