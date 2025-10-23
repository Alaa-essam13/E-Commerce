package com.example.ecommerce.ecommerce.model.vto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagedProductResponseVTO {
    private List<ProductVTO> content;
    private Long totalElements;
}
