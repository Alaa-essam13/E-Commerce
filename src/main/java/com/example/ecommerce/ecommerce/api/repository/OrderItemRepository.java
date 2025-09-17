package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository {
    void addOrderItem(OrderItem orderItem);

    List<OrderItem> findAllItemsOfOrder(Long id);

    Optional<OrderItem> findOrderItemById(Long id);
}
