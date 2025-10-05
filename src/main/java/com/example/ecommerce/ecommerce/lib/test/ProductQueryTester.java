package com.example.ecommerce.ecommerce.lib.test;

import com.example.ecommerce.ecommerce.model.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductQueryTester implements CommandLineRunner {

    private final ProductQueryBuilderRepository productQueryBuilder;

    public ProductQueryTester(ProductQueryBuilderRepository productQueryBuilder) {
        this.productQueryBuilder = productQueryBuilder;
    }

    @Override
    public void run(String... args) {

        ProductFilter filter = new ProductFilter();
        filter.setSearch("Laptop");

        List<Product> list = productQueryBuilder.getList(filter, 0, 10);
        long count = productQueryBuilder.getCount(filter);

    }
}

