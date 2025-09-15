package com.example.ecommerce.ecommerce.core.repository.jpa;

import com.example.ecommerce.ecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
}
