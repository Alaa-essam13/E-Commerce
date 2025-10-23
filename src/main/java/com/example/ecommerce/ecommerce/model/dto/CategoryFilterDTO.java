package com.example.ecommerce.ecommerce.model.dto;

import com.example.ecommerce.ecommerce.model.enums.SortDirection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryFilterDTO {
    private String searchTxt;

    private SortDirection sortDirection;


}
