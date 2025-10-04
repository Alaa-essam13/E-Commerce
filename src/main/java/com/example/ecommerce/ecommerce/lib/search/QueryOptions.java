package com.example.ecommerce.ecommerce.lib.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryOptions {
    private String sortBy;
    private boolean asc;
    private int page;
    private int size;
}
