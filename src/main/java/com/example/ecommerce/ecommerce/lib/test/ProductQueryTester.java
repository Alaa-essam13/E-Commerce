package com.example.ecommerce.ecommerce.lib.test;

import com.example.ecommerce.ecommerce.core.repository.query.ProductQueryBuilderRepositoryImpl;
import com.example.ecommerce.ecommerce.model.dto.ProductFilterDTO;
import com.example.ecommerce.ecommerce.model.enums.ProductSortBy;
import com.example.ecommerce.ecommerce.model.enums.SortDirection;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ProductQueryTester implements CommandLineRunner {

    private final ProductQueryBuilderRepositoryImpl productQueryBuilder;



    @Override
    public void run(String... args) {

        ProductFilterDTO filter=ProductFilterDTO.builder()
                .category(2)
                .maxPrice(10000.0)
                .minPrice(20000.0)
                .searchTxt("alaa")
                .sortDirection(SortDirection.ASC)
                .sortType(ProductSortBy.PRICE)
                .build();
        productQueryBuilder.getList(filter,0,10).forEach(System.out::println);
        System.out.println(productQueryBuilder.getCount(filter));
    }
}

