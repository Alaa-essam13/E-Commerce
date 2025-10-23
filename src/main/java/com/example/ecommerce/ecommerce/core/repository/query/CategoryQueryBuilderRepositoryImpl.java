package com.example.ecommerce.ecommerce.core.repository.query;

import com.example.ecommerce.ecommerce.lib.search.AbstractCriteriaQueryBuilder;
import com.example.ecommerce.ecommerce.lib.search.HqlBuilder;
import com.example.ecommerce.ecommerce.model.dto.CategoryFilterDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.enums.SortDirection;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryQueryBuilderRepositoryImpl extends AbstractCriteriaQueryBuilder<Category, CategoryFilterDTO> {
    protected CategoryQueryBuilderRepositoryImpl() {
        super(Category.class);
    }

    @Override
    protected HqlBuilder<Category> buildQuery(CategoryFilterDTO filter) {

        HqlBuilder<Category> builder = new HqlBuilder<>(Category.class,"c");
        builder.select().where(c->{
            if(!filter.getSearchTxt().isEmpty())
                c.andLike("name","name", filter.getSearchTxt());
        });

        if (filter.getSortDirection().equals(SortDirection.ASC)) {
            builder.direction(HqlBuilder.Direction.ASC);
        } else if (filter.getSortDirection().equals(SortDirection.DESC)) {
            builder.direction(HqlBuilder.Direction.DESC);
        }

        return builder;
    }
}
