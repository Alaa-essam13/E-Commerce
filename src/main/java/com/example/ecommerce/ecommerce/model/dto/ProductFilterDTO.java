package com.example.ecommerce.ecommerce.model.dto;


import com.example.ecommerce.ecommerce.model.enums.ProductSortBy;
import com.example.ecommerce.ecommerce.model.enums.SortDirection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductFilterDTO {


    private String searchTxt;

    private Double minPrice;

    private Double maxPrice;

    private ProductSortBy sortType;

    private SortDirection sortDirection;

    private Integer category;

}
