package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.CategoryRepository;
import com.example.ecommerce.ecommerce.api.service.CategoryService;
import com.example.ecommerce.ecommerce.mapper.GeneralMapper;
import com.example.ecommerce.ecommerce.model.dto.CategoryDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.vto.CategoriesVTO;
import com.example.ecommerce.ecommerce.model.vto.CategoryVTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final GeneralMapper mapper;
    @Override
    public CategoriesVTO getAllCategories() {
        return mapper.toCategoriesVTO(0,categoryRepository.getCategories());
    }

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category c = mapper.toCategory(categoryDTO);
        c.setCreatedAt(LocalDateTime.now());
        c.setUpdatedAt(LocalDateTime.now());
        categoryRepository.addCategory(c);
    }

    @Override
    public CategoryVTO getCategoryById(Integer id) {
        return mapper.toCategoryVTO(categoryRepository.getCategoryById(id).orElseThrow());
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category=categoryRepository.getCategoryById(id).orElseThrow();
        categoryRepository.deletebyId(category);
    }
}
