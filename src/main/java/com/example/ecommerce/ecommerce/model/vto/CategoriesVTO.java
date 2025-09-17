package com.example.ecommerce.ecommerce.model.vto;

import com.example.ecommerce.ecommerce.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesVTO {
    private Integer count;
    private List<CategoryVTO> categories;
}
