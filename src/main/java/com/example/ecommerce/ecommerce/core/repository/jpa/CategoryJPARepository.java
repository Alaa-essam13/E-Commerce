package com.example.ecommerce.ecommerce.core.repository.jpa;

import com.example.ecommerce.ecommerce.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJPARepository extends JpaRepository<Category, Integer> {
}
