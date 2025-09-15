package com.example.ecommerce.ecommerce.core.repository.jpa;


import com.example.ecommerce.ecommerce.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJPARepository extends JpaRepository<OrderItem, Long> {
}
