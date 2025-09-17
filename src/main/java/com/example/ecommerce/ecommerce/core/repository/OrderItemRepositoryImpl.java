package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.OrderItemRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.OrderItemJPARepository;
import com.example.ecommerce.ecommerce.model.entity.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@AllArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final OrderItemJPARepository orderItemJPARepository;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemJPARepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItem(Long id) {
        return orderItemJPARepository.getOrderItemById(id);
    }

    @Override
    public List<OrderItem> findAllItemsOfOrder(Long id) {
        return orderItemJPARepository.findAllByOrderId(id);
    }
}
