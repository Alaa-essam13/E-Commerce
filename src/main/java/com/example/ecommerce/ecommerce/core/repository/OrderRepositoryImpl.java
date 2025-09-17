package com.example.ecommerce.ecommerce.core.repository;


import com.example.ecommerce.ecommerce.api.repository.OrderRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.OrderJPARepository;
import com.example.ecommerce.ecommerce.model.entity.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJPARepository orderJPARepository;

    @Override
    public List<Order> findAllOrders() {
        return List.of();
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        return orderJPARepository.findById(id);
    }

    @Override
    public void addOrder(Order order) {
        orderJPARepository.save(order);
    }
}
