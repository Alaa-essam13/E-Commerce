package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.CategoryRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.CategoryJPARepository;
import com.example.ecommerce.ecommerce.model.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJPARepository categoryJPARepository;


    @Override
    public void addCategory(Category category) {
        categoryJPARepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return categoryJPARepository.findById(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryJPARepository.findAll();
    }

    @Override
    public void deletebyId(Category category) {
        categoryJPARepository.delete(category);
    }
}
