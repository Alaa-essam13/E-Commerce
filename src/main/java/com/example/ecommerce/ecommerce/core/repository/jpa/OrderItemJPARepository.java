package com.example.ecommerce.ecommerce.core.repository.jpa;


import com.example.ecommerce.ecommerce.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemJPARepository extends JpaRepository<OrderItem, Long> {

    @Query("SELECT oi FROM OrderItem oi where oi.order.id = :id")
    List<OrderItem> findAllByOrderId(@Param("id") Long id);
}
