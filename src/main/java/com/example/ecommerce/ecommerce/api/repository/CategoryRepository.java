package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.dto.CategoryFilterDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository{
    void addCategory(Category category);

    Optional<Category> getCategoryById(Integer id);

    List<Category> getCategories(CategoryFilterDTO categoryFilterDTO, Integer offset, Integer limit);

    void deletebyId(Category category);
}
