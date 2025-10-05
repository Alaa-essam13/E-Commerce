package com.example.ecommerce.ecommerce.lib.test;

import com.example.ecommerce.ecommerce.lib.search.AbstractCriteriaQueryBuilder;
import com.example.ecommerce.ecommerce.lib.search.HqlBuilder;
import com.example.ecommerce.ecommerce.model.entity.Product;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ProductQueryBuilderRepository extends AbstractCriteriaQueryBuilder<Product,ProductFilter> {
    protected ProductQueryBuilderRepository() {
        super(Product.class);
    }

    @Override
    protected HqlBuilder<Product> buildQuery(ProductFilter filter) {
        HqlBuilder<Product> builder = new HqlBuilder<>(Product.class, "p");
        builder.select().where(c->{
            if (filter.getActive() != null)
                c.andEq("active", "active", filter.getActive());

            if (filter.getCategory() != null)
                c.andEq("category.name", "category", filter.getCategory());

            if (filter.getMinPrice() != null && filter.getMaxPrice() != null)
                c.andBetween("price", "minPrice", "maxPrice", filter.getMinPrice(), filter.getMaxPrice());

            if (filter.getSearch() != null && !filter.getSearch().isEmpty()) {
                c.openGroup();
                c.andLike("name", "name", filter.getSearch());
                c.orLike("description", "desc", filter.getSearch());
                c.closeGroup();
            }
        }).orderBy("price");
        System.out.println(builder.getQueryString());
        return builder;
    }
}
