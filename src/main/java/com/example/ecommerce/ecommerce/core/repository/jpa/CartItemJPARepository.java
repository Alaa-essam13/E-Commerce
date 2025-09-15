package com.example.ecommerce.ecommerce.core.repository.jpa;

import com.example.ecommerce.ecommerce.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJPARepository extends JpaRepository<CartItem, Long> {
}
