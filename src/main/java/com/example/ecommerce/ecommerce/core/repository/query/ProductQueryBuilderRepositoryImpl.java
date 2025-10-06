package com.example.ecommerce.ecommerce.core.repository.query;

import com.example.ecommerce.ecommerce.lib.search.AbstractCriteriaQueryBuilder;
import com.example.ecommerce.ecommerce.lib.search.HqlBuilder;
import com.example.ecommerce.ecommerce.model.dto.ProductFilterDTO;
import com.example.ecommerce.ecommerce.model.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductQueryBuilderRepositoryImpl extends AbstractCriteriaQueryBuilder<Product, ProductFilterDTO> {


    protected ProductQueryBuilderRepositoryImpl() {
        super(Product.class);
    }

    @Override
    protected HqlBuilder<Product> buildQuery(ProductFilterDTO filter) {
        HqlBuilder<Product> builder = new HqlBuilder<>(Product.class, "p");
        builder.select().where(c->{
            if(!filter.getSearchTxt().isEmpty())
                c.andLike("name","name",filter.getSearchTxt())
                        .orLike("description","description",filter.getSearchTxt());
            if(filter.getMinPrice()!=null&&filter.getMaxPrice()==null)
                c.andBetween("price", "minPrice", "maxPrice", filter.getMinPrice(), Double.MAX_VALUE);
            else if(filter.getMinPrice()==null&&filter.getMaxPrice()!=null)
                c.andBetween("price", "minPrice", "maxPrice",0.0 , filter.getMaxPrice());
            if(filter.getMinPrice()!=null&&filter.getMaxPrice()!=null)
                c.andBetween("price", "minPrice", "maxPrice", filter.getMinPrice(), filter.getMaxPrice());

        });
        if(filter.getSortType().name().equals("price")){
            builder.orderBy("price");
        } else if (filter.getSortType().name().equals("newest")) {
            builder.orderBy("createdAt");
        }
        if(filter.getSortDirection().name().equals("desc")) {
            builder.direction(HqlBuilder.Direction.DESC);
        }else if(filter.getSortDirection().name().equals("asc")){
            builder.direction(HqlBuilder.Direction.ASC);
        }
        System.out.println(builder.getQueryString());
        return builder;
    }
}
