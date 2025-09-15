package com.example.ecommerce.ecommerce.core.repository.jpa;

import com.example.ecommerce.ecommerce.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartJPARepoitory extends JpaRepository<Cart, Long> {
}
