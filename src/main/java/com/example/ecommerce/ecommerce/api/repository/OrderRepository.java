package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository{

    List<Order> findAllOrders();

    Optional<Order> findOrderById(Long id);

    void addOrder(Order order);

}
