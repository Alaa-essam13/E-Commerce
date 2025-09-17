package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository {
    void addOrderItem(OrderItem orderItem);
    OrderItem getOrderItem(Long id);

    List<OrderItem> findAllItemsOfOrder(Long id);
}
