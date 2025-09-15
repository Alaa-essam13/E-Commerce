package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.CategoryDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.vto.CategoriesVTO;
import com.example.ecommerce.ecommerce.model.vto.CategoryVTO;

public interface CategoryService {
    CategoriesVTO getAllCategories();
    void addCategory(CategoryDTO  categoryDTO);
    CategoryVTO getCategoryById(Integer id);
}
